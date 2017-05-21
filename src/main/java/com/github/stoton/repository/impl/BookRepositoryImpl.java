package com.github.stoton.repository.impl;

import com.github.stoton.domain.Book;
import com.github.stoton.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository<Book> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Book find(long id) {
        Book book = (Book) getSession().createQuery("from " + Book.class.getName() + " where id = :id")
                .setParameter("id", id).uniqueResult();
        return book;
    }

    @Override
    public List<Book> getAll() {
        return getSession().createCriteria(Book.class).list();
    }

    @Override
    public void save(Book book) {
        getSession().save(book);
    }

    @Override
    public void update(Book book) {
        getSession().update(book);
    }

    @Override
    public boolean isExist(Book book) {
        return getSession().createQuery(
                "from " + Book.class.getName() +  " where author = :author and title = :title")
                .setParameter("author", book.getAuthor())
                .setParameter("title", book.getTitle())
                .uniqueResult() != null;
    }

    @Override
    public void delete(long id) {
        Book book = (Book) getSession().createQuery("from " + Book.class.getName() + " where id = :id")
                .setParameter("id", id)
                .uniqueResult();

        getSession().delete(book);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
