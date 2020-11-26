import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Handler implements InvocationHandler {

    private final SomeInterface original;

    public Handler(SomeInterface original) {
        this.original = original;
    }

    public Object invoke(Object proxy, Method method, Object... args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("BEFORE");
        method.invoke(original, args);
        System.out.println("AFTER");
        return null;
    }

}
