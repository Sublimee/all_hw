import org.junit.Test;

import java.lang.reflect.Proxy;

public class TestClass {

    @Test
    public void proxyTest() {
        Original original = new Original();
        Handler handler = new Handler(original);
        SomeInterface f = (SomeInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{SomeInterface.class},
                handler);
        f.originalMethod("Hallo");
    }

}
