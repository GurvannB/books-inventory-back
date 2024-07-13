package fr.assofl.inventory.exceptions;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends BusinessException {
    private static final String DEFAULT_MESSAGE = "error.book.notFound";
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;


    public BookNotFoundException() {
        super(DEFAULT_MESSAGE, HTTP_STATUS);
    }

    public BookNotFoundException(String message) {
        super(message, HTTP_STATUS);
    }
}
