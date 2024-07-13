package fr.assofl.inventory.controllers;

import fr.assofl.inventory.dtos.BookDto;
import fr.assofl.inventory.dtos.requests.BookRequest;
import fr.assofl.inventory.entities.Book;
import fr.assofl.inventory.services.BooksService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    @GetMapping
    public List<BookDto> getBooks() {
        return booksService.getAll().stream().map(BookDto::from).toList();
    }

    @GetMapping("/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        return BookDto.from(booksService.getOne(bookId));
    }

    @PostMapping
    public BookDto addBook(@Validated @RequestBody BookRequest bookRequest) {
        return BookDto.from(booksService.createOne(bookRequest));
    }

    @PutMapping("/{bookId}")
    public BookDto updateBook(@PathVariable Long bookId, @Validated @RequestBody BookRequest bookRequest) {
        return BookDto.from(booksService.updateOne(bookId, bookRequest));
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        booksService.deleteOne(bookId);
    }
}
