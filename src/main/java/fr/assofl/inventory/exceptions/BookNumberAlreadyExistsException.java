package fr.assofl.inventory.exceptions;

import org.springframework.http.HttpStatus;

public class BookNumberAlreadyExistsException extends BusinessException {
    private static final String DEFAULT_MESSAGE = "error.book.alreadyExists";
    private static final HttpStatus HTTP_STATUS = HttpStatus.CONFLICT;


    public BookNumberAlreadyExistsException() {
        super(DEFAULT_MESSAGE, HTTP_STATUS);
    }

    public BookNumberAlreadyExistsException(String message) {
        super(message, HTTP_STATUS);
    }
}
