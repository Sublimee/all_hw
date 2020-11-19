import framework.TestClassRunner;
import framework.exceptions.TestFrameworkException;

public class Main {

    public static void main(String[] args) {
        try {
            TestClassRunner testRunner = new TestClassRunner(MyItemsTest.class);
            testRunner.run();
        } catch (TestFrameworkException e) {
            System.err.printf("Test failed with error %s\n", e.getMessage());
        }
    }

}
