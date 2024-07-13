package fr.assofl.inventory.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String error;
    private String message;
}
