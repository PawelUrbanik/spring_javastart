package pl.javasatart.springdatarestconf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Producer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;
    private double totalIncome;
    @OneToMany(mappedBy = "producer")
    private List<Product> products;

    public Producer() {
    }

    public Producer(String name, String country, double totalIncome) {
        this.name = name;
        country = country;
        this.totalIncome = totalIncome;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Double.compare(producer.totalIncome, totalIncome) == 0 &&
                Objects.equals(id, producer.id) &&
                Objects.equals(name, producer.name) &&
                Objects.equals(country, producer.country) &&
                Objects.equals(products, producer.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, totalIncome, products);
    }
}
