package fr.assofl.inventory.exceptions;

import org.springframework.http.HttpStatus;

public class BookTypeIsbnAlreadyExistsException extends BusinessException {
    private static final String DEFAULT_MESSAGE = "error.bookType.alreadyExists";
    private static final HttpStatus HTTP_STATUS = HttpStatus.CONFLICT;


    public BookTypeIsbnAlreadyExistsException() {
        super(DEFAULT_MESSAGE, HTTP_STATUS);
    }

    public BookTypeIsbnAlreadyExistsException(String message) {
        super(message, HTTP_STATUS);
    }
}
