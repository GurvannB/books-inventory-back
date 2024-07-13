package fr.assofl.inventory.controllers;

import fr.assofl.inventory.dtos.BookTypeDto;
import fr.assofl.inventory.dtos.requests.BookTypeRequest;
import fr.assofl.inventory.services.BookTypesService;
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
@RequestMapping("/bookTypes")
public class BookTypesController {
    private final BookTypesService bookTypesService;

    @GetMapping
    public List<BookTypeDto> getBookTypes() {
        return bookTypesService.getAll().stream().map(BookTypeDto::from).toList();
    }

    @GetMapping("/{bookTypeId}")
    public BookTypeDto getBookType(@PathVariable Long bookTypeId) {
        return BookTypeDto.from(bookTypesService.getOne(bookTypeId));
    }

    @PostMapping
    public BookTypeDto createOne(@Validated @RequestBody BookTypeRequest bookTypeRequest) {
        return BookTypeDto.from(bookTypesService.createOne(bookTypeRequest));
    }

    @PutMapping("/{bookTypeId}")
    public BookTypeDto updateBookType(@PathVariable Long bookTypeId, @Validated @RequestBody BookTypeRequest bookTypeRequest) {
        return BookTypeDto.from(bookTypesService.updateOne(bookTypeId, bookTypeRequest));
    }

    @DeleteMapping("/{bookTypeId}")
    public void deleteBookType(@PathVariable Long bookTypeId) {
        bookTypesService.deleteOne(bookTypeId);
    }
}
