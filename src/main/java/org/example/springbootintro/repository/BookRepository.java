package org.example.springbootintro.repository;

import java.util.List;
import java.util.Optional;
import org.example.springbootintro.model.Book;

public interface BookRepository {
    Book save(Book book);

    Optional<Book> findById(Long id);

    List<Book> findAll();
}
