package pl.javastart.jpaspringboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @EmbeddedId
    private BookKey bookKey;
    private String title;
    //@Transient
    private String author;

    public BookKey getBookKey() {
        return bookKey;
    }

    public void setBookKey(BookKey bookKey) {
        this.bookKey = bookKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //@Transient
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" +
                ", title='" + title + '\'' +
                ", Author='" + author + '\'' +
                '}';
    }
}
