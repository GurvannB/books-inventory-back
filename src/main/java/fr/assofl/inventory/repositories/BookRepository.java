package fr.assofl.inventory.repositories;

import fr.assofl.inventory.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
