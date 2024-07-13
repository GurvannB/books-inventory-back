package fr.assofl.inventory.dtos;

import fr.assofl.inventory.entities.Book;
import fr.assofl.inventory.entities.BookType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    private Long id;
    private Long number;
    private String bookCondition;
    private String comment;
    private BookTypeDto type;

    private static BookDto.BookDtoBuilder fromBase(Book book) {
        return BookDto.builder()
                .id(book.getBookId())
                .number(book.getBookNumber())
                .bookCondition(book.getBookCondition())
                .comment(book.getComment());
    }

    public static BookDto from(Book book) {
        return BookDto.fromBase(book)
                .type(BookTypeDto.fromWithoutBooks(book.getBookType()))
                .build();
    }

    public static BookDto fromWithoutBookType(Book book) {
        return BookDto.fromBase(book)
                .build();
    }
}
