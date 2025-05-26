package org.example.springbootintro.repository;

import jakarta.transaction.Transactional;
import java.util.List;
import org.example.springbootintro.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public BookRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book save(Book book) {
        sessionFactory.getCurrentSession().persist(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return sessionFactory.getCurrentSession()
            .createQuery("from Book", Book.class)
            .getResultList();
    }
}
