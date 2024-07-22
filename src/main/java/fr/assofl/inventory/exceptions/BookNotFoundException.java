package fr.assofl.inventory.exceptions;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends BusinessException {
    private static final String DEFAULT_MESSAGE = "Le manuel n'a pas été trouvé";
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;


    public BookNotFoundException() {
        super(DEFAULT_MESSAGE, HTTP_STATUS);
    }

    public BookNotFoundException(String message) {
        super(message, HTTP_STATUS);
    }
}
