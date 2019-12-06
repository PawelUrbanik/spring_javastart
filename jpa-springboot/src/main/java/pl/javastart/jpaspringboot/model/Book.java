package pl.javastart.jpaspringboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(
            name = "tytul",
            nullable = false,
            unique = true
    )
    private String title;
    //@Transient
    private String author;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id=id;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", Author='" + author + '\'' +
                '}';
    }

    @PrePersist
    public void prePersist(){
        System.out.println("Zapis obiektu: " + this);
    }

    @PostPersist
    public void postPersist(){
        System.out.println("Zapisano obiekt: " + this);
    }
}
