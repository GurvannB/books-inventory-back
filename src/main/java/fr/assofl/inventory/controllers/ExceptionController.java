package fr.assofl.inventory.controllers;

import fr.assofl.inventory.dtos.ErrorDto;
import fr.assofl.inventory.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<ErrorDto> errors = ex
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map((error) -> ErrorDto.builder()
                            .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                            .message(((FieldError) error).getField()+" "+error.getDefaultMessage())
                            .build())
                .collect(Collectors.toList());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<List<ErrorDto>> exception(BusinessException exception) {
        ErrorDto error = ErrorDto
                .builder()
                .error(exception.getStatus().getReasonPhrase())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(List.of(error), exception.getStatus());
    }
}

