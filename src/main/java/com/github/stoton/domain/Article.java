package com.github.stoton.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String author;
    @Size(max = 5000)
    private String content;
    private String title;
    private LocalDate localDate;

    public Article(String author, String content, String title, LocalDate localDate) {
        this.author = author;
        this.content = content;
        this.title = title;
        localDate = LocalDate.now();
    }

    public Article(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (author != null ? !author.equals(article.author) : article.author != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        return localDate != null ? localDate.equals(article.localDate) : article.localDate == null;
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
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
