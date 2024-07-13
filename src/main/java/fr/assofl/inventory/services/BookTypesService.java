package fr.assofl.inventory.services;

import fr.assofl.inventory.dtos.requests.BookTypeRequest;
import fr.assofl.inventory.entities.BookType;
import fr.assofl.inventory.exceptions.BookTypeIsbnAlreadyExistsException;
import fr.assofl.inventory.exceptions.BookTypeNotFoundException;
import fr.assofl.inventory.repositories.BookTypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookTypesService {
    private final BookTypesRepository bookTypesRepository;

    public List<BookType> getAll() {
        return bookTypesRepository.findAll();
    }

    public BookType getOne(Long bookTypeIsbn) {
        return bookTypesRepository.findById(bookTypeIsbn).orElseThrow(BookTypeNotFoundException::new);
    }

    public BookType createOne(BookTypeRequest bookTypeRequest) {
        if (bookTypesRepository.existsByIsbn(bookTypeRequest.getIsbn())) throw new BookTypeIsbnAlreadyExistsException();
        return bookTypesRepository.save(BookTypeRequest.toEntity(bookTypeRequest));
    }

    public BookType updateOne(Long bookTypeId, BookTypeRequest bookTypeRequest) {
        BookType bookType = getOne(bookTypeId);
        if (!bookType.getIsbn().equals(bookTypeRequest.getIsbn())) {
            if (bookTypesRepository.existsByIsbn(bookTypeRequest.getIsbn())) throw new BookTypeIsbnAlreadyExistsException();
        }

        bookType.setIsbn(bookTypeRequest.getIsbn());
        bookType.setEditor(bookTypeRequest.getEditor());
        bookType.setGrade(bookTypeRequest.getGrade());
        bookType.setSubject(bookTypeRequest.getSubject());
        bookType.setCoverUrl(bookTypeRequest.getCoverUrl());

        return bookTypesRepository.save(bookType);
    }

    public void deleteOne(Long bookTypeId) {
        bookTypesRepository.deleteById(bookTypeId);
    }
}
