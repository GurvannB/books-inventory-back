package fr.assofl.inventory.repositories;

import fr.assofl.inventory.entities.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypesRepository extends JpaRepository<BookType, Long> {
}
