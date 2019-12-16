package pl.javastart.jpadynamicqueries.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_dynamic")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.deleteAll", query = "DELETE FROM Product p"),
        @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
})
public class Product implements Serializable {
    public static final long versionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String producer;
    private Double price;

    public Product() {
    }

    public Product(String name, String porducer, Double price) {
        this.name = name;
        this.producer = porducer;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPorducer() {
        return producer;
    }

    public void setPorducer(String porducer) {
        this.producer = porducer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", porducer='" + producer + '\'' +
                ", price=" + price +
                '}';
    }
}
