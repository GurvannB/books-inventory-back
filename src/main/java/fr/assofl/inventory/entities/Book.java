package fr.assofl.inventory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
    @Id
    private Long bookNumber;

    @ManyToOne
    private BookType bookType;
}
