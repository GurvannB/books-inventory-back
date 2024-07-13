package fr.assofl.inventory.exceptions;

import org.springframework.http.HttpStatus;

public class BookTypeNotFoundException extends BusinessException {
    private static final String DEFAULT_MESSAGE = "error.bookType.notFound";
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;


    public BookTypeNotFoundException() {
        super(DEFAULT_MESSAGE, HTTP_STATUS);
    }

    public BookTypeNotFoundException(String message) {
        super(message, HTTP_STATUS);
    }
}
