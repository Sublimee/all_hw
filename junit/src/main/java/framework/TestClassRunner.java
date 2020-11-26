package framework;


import framework.annotations.Test;
import framework.exceptions.TestFrameworkException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClassRunner {

    private final Class clazz;
    private final List<Method> methods;

    private int passed;
    private int failed;

    public TestClassRunner(Class clazz) {
        this.clazz = clazz;
        methods = extractSuitableMethods();
    }


    public void run() throws TestFrameworkException {
        Object instance = ReflectionUtil.instantiate(clazz);
        if (instance == null) {
            throw new TestFrameworkException("Cannot run tests due to class instantiation issue");
        }

        for (Method nextMethod : methods) {
            ColoredOutput.title(String.format("Execute test: %s", nextMethod.getName()));
            try {
                ReflectionUtil.callMethod(instance, nextMethod.getName());
                ColoredOutput.positive("passed");
                passed++;
            } catch (Exception e) {
                ColoredOutput.err(String.format("Failed test %s", nextMethod.getName()));
                e.printStackTrace(System.out);
                failed++;
            }
            ColoredOutput.finishTest();
        }

        ColoredOutput.stat(passed, failed);
    }

    private List<Method> extractSuitableMethods() {
        return Arrays
                .stream(this.clazz.getDeclaredMethods())
                .filter(this::isMethodSignatureValid)
                .collect(Collectors.toList());
    }

    private boolean isMethodSignatureValid(Method method) {
        boolean isPublic = Modifier.isPublic(method.getModifiers());
        boolean isVoid = method.getReturnType().equals(Void.TYPE);
        if (!isPublic || !isVoid || method.getParameterCount() != 0) {
            return false;
        }

        for (Annotation annotation : method.getDeclaredAnnotations()) {
            if (Test.class.equals(annotation.annotationType())) {
                return true;
            }
        }
        return false;
    }

}
