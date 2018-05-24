package by.itacademy.exceptions;

public class CustomerBuilderException extends Exception {
    public CustomerBuilderException(Throwable cause) {
        super(cause);
    }

    public CustomerBuilderException(String message) {
        super(message);
    }
}
