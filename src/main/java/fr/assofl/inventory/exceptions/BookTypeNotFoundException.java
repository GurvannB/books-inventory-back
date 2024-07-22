package fr.assofl.inventory.exceptions;

import org.springframework.http.HttpStatus;

public class BookTypeNotFoundException extends BusinessException {
    private static final String DEFAULT_MESSAGE = "Le type de manuel n'a pas été trouvé";
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;


    public BookTypeNotFoundException() {
        super(DEFAULT_MESSAGE, HTTP_STATUS);
    }

    public BookTypeNotFoundException(String message) {
        super(message, HTTP_STATUS);
    }
}
