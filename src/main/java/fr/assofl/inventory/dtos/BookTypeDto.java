package fr.assofl.inventory.dtos;

import fr.assofl.inventory.entities.BookType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookTypeDto {
    private Long id;
    private Long isbn;
    private String publisher;
    private String grade;
    private String level;
    private String coverUrl;
    private List<BookDto> books;

    private static BookTypeDto.BookTypeDtoBuilder fromBase(BookType bookType) {
        return BookTypeDto.builder()
                .id(bookType.getBookTypeId())
                .isbn(bookType.getIsbn())
                .publisher(bookType.getEditor())
                .grade(bookType.getGrade())
                .level(bookType.getSubject())
                .coverUrl(bookType.getCoverUrl());
    }

    public static BookTypeDto from(BookType bookType) {
        return BookTypeDto.fromBase(bookType)
                .books(bookType.getBooks() != null ? bookType.getBooks().stream().map(BookDto::fromWithoutBookType).toList() : List.of())
                .build();
    }

    public static BookTypeDto fromWithoutBooks(BookType bookType) {
        return BookTypeDto.fromBase(bookType)
                .build();
    }
}
