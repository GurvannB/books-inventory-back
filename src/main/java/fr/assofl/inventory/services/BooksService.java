package fr.assofl.inventory.services;

import fr.assofl.inventory.dtos.requests.BookRequest;
import fr.assofl.inventory.entities.Book;
import fr.assofl.inventory.entities.BookType;
import fr.assofl.inventory.exceptions.BookNotFoundException;
import fr.assofl.inventory.exceptions.BookNumberAlreadyExistsException;
import fr.assofl.inventory.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BookRepository bookRepository;
    private final BookTypesService bookTypesService;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getOne(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public Book getOneByNumber(Long bookNumber) {
        return bookRepository.findByBookNumber(bookNumber).orElseThrow(BookNotFoundException::new);
    }

    public Book createOne(BookRequest bookRequest) throws BookNumberAlreadyExistsException {
        if (bookRepository.existsByBookNumber(bookRequest.getBookNumber())) throw new BookNumberAlreadyExistsException();
        BookType bookType = bookTypesService.getOne(bookRequest.getBookTypeId());
        return bookRepository.save(BookRequest.toEntity(bookRequest,  bookType));
    }

    public Book updateOne(Long bookId, BookRequest bookRequest) {
        Book book = this.getOne(bookId);
        book.setBookNumber(bookRequest.getBookNumber());
        book.setBookCondition(bookRequest.getBookCondition());
        book.setComment(bookRequest.getComment());

        BookType bookType = bookTypesService.getOne(bookRequest.getBookTypeId());
        if (!bookRequest.getBookNumber().equals(book.getBookNumber())) {
            if (bookRepository.existsByBookNumber(bookRequest.getBookNumber())) throw new BookNumberAlreadyExistsException();
        }
        book.setBookType(bookType);

        return bookRepository.save(book);
    }

    public void deleteOne(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
