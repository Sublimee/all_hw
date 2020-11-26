package framework.exceptions;

import java.io.Serial;

public class TestFrameworkException extends Exception {

    @Serial
    private static final long serialVersionUID = -2647434850723954452L;

    public TestFrameworkException(String s) {
        super(s);
    }

}
