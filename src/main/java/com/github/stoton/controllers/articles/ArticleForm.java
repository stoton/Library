package com.github.stoton.controllers.articles;

import com.github.stoton.domain.Article;

import java.time.LocalDate;

public class ArticleForm {
    private long id;
    private String author;
    private String content;
    private String title;
    private LocalDate localDate;

    public ArticleForm(String author, String content, String title) {
        this.author = author;
        this.content = content;
        this.title = title;
        localDate = LocalDate.now();
    }

    public ArticleForm() {
        localDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Article convertToArticle() {

        Article article = new Article();

        article.setAuthor(this.getAuthor());
        article.setContent(this.getContent());
        article.setLocalDate(this.getLocalDate());
        article.setTitle(this.getTitle());

        return article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleForm that = (ArticleForm) o;

        if (id != that.id) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return localDate != null ? localDate.equals(that.localDate) : that.localDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (localDate != null ? localDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
