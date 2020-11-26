package framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public final class ReflectionUtil {

    private ReflectionUtil() {
    }

    public static <T> T instantiate(Class<T> type, Object... args) {
        try {
            if (args.length == 0) {
                return type.getDeclaredConstructor().newInstance();
            } else {
                Class<?>[] classes = getClasses(args);
                return type.getDeclaredConstructor(classes).newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void callMethod(Object classInstance, String methodName, Object... args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = null;
        try {
            method = classInstance.getClass().getDeclaredMethod(methodName, getClasses(args));
            method.trySetAccessible();
            method.invoke(classInstance, args);
        } finally {
            if (method != null) {
                method.setAccessible(false);
            }
        }
    }

    public static Class<?>[] getClasses(Object... args) {
        return Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
    }

}
