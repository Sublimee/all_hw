package framework;

public class AssertionFailedException extends AssertionError {

    public AssertionFailedException() {
    }

    public AssertionFailedException(String message) {
        super(defaultString(message));
    }

    private static String defaultString(String message) {
        return message == null ? "" : message;
    }

}
