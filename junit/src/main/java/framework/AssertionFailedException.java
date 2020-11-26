package framework;

import java.io.Serial;

public class AssertionFailedException extends AssertionError {

    @Serial
    private static final long serialVersionUID = -2013992150824157232L;

    public AssertionFailedException() {
    }

    public AssertionFailedException(String message) {
        super(defaultString(message));
    }

    private static String defaultString(String message) {
        return message == null ? "" : message;
    }

}
