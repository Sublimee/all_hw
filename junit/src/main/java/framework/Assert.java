package framework;

public final class Assert {

    private Assert() {
    }

    public static void assertTrue(String message, boolean condition) {
        if (!condition) {
            fail(message);
        }
    }

    public static void assertTrue(boolean condition) {
        assertTrue(null, condition);
    }

    private static void fail(String message) {
        throw message == null ? new AssertionFailedException() : new AssertionFailedException(message);
    }

}
