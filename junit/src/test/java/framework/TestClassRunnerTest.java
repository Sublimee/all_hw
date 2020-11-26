package framework;


import framework.exceptions.TestFrameworkException;
import org.junit.Test;

public class TestClassRunnerTest {

    @Test
    public void executeTest() throws TestFrameworkException {
        TestClassRunner testRunner = new TestClassRunner(MyItemsTest.class);
        testRunner.run();
    }

}
