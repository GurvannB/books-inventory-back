package fr.assofl.inventory.dtos.requests;

import fr.assofl.inventory.entities.Book;
import fr.assofl.inventory.entities.BookType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookRequest {
    @NotNull
    private Long bookNumber;

    @NotNull
    private Long bookTypeId;

    @NotNull
    @NotEmpty
    private String bookCondition;

    private String comment;

    public static Book toEntity(BookRequest bookRequest, BookType bookType) {
        return Book.builder()
                .bookNumber(bookRequest.getBookNumber())
                .bookType(bookType)
                .bookCondition(bookRequest.getBookCondition())
                .comment(bookRequest.getComment())
                .build();
    }
}
