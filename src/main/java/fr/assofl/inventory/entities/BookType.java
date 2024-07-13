package fr.assofl.inventory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookTypeId;

    @Column(nullable = false, unique = true)
    private Long isbn;

    @Column(nullable = false)
    private String editor;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String coverUrl;

    @OneToMany(mappedBy = "bookType")
    private List<Book> books;
}
