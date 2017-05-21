package com.github.stoton.repository.impl;

import com.github.stoton.domain.Article;
import com.github.stoton.repository.ArticleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleRepositoryImpl implements ArticleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Article> getAll() {
        return getSession().createCriteria(Article.class).list();
    }

    @Override
    public void save(Article article) {
        getSession().save(article);
    }

    @Override
    public void update(Article article) {
        getSession().update(article);
    }

    @Override
    public void delete(long id) {
        getSession().delete(id);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
