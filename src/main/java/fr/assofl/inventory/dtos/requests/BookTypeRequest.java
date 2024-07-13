package fr.assofl.inventory.dtos.requests;

import fr.assofl.inventory.entities.BookType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookTypeRequest {
    @NotNull
    private Long isbn;

    @NotNull
    @NotEmpty
    private String editor;

    @NotNull
    @NotEmpty
    private String grade;

    @NotNull
    @NotEmpty
    private String subject;

    @NotNull
    @NotEmpty
    private String coverUrl;

    public static BookType toEntity(BookTypeRequest bookTypeRequest) {
        return BookType.builder()
                .isbn(bookTypeRequest.getIsbn())
                .editor(bookTypeRequest.getEditor())
                .grade(bookTypeRequest.getGrade())
                .subject(bookTypeRequest.getSubject())
                .coverUrl(bookTypeRequest.getCoverUrl())
                .build();
    }
}
