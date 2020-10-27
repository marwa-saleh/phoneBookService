package main.java.com.phonebookservice.exception;

public class PhoneBookControllerException extends RuntimeException {

    /**
     * Exception class for phonebook.
     *
     * @param message the error message
     */
    public PhoneBookControllerException(final String message) {
        super(message);
    }

}
