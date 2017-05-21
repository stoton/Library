package com.github.stoton.controllers.books;


import com.github.stoton.domain.Book;

public class BookForm {
    private long id;
    private String author;
    private String title;
    private boolean isBorrow;

    public BookForm(long id, String author, String title, int amount, boolean isBorrow) {
        this.id = id;
        this.author = author;
        this.title = title;
        isBorrow = true;
    }

    Book convertToBook() {
       Book book = new Book();
       book.setId(this.id);
       book.setAuthor(this.author);
       book.setTitle(this.title);

       return book;
    }

    public BookForm() {
        isBorrow = true;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookForm bookForm = (BookForm) o;

        if (id != bookForm.id) return false;
        if (isBorrow != bookForm.isBorrow) return false;
        if (author != null ? !author.equals(bookForm.author) : bookForm.author != null) return false;
        return title != null ? title.equals(bookForm.title) : bookForm.title == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (isBorrow ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookForm{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isBorrow=" + isBorrow +
                '}';
    }
}
