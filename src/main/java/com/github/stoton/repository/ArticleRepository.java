package com.github.stoton.repository;


import com.github.stoton.domain.Article;

import java.util.List;

public interface ArticleRepository {
    List<Article> getAll();
    void save(Article article);
    void update(Article article);
    void delete(long id);
}
