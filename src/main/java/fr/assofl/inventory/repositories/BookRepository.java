package fr.assofl.inventory.repositories;

import fr.assofl.inventory.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookNumber(Long bookNumber);
    boolean existsByBookNumber(Long bookNumber);
}
