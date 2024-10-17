package br.com.ipr.infra.exceptions.member;

public class PasswordTooShortException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Password too short. It must be at least 8 characters long.";

    public PasswordTooShortException() {
        super(DEFAULT_MESSAGE);
    }

    public PasswordTooShortException(String message) {
        super(message);
    }
}
