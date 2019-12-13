package pl.javastart.springjpaotm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_order")
    private Long id;

    @ManyToMany
    @JoinTable(name = "order_products",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id_order")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id_product")}
    )
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order() {
    }

    public Order(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client.getFirstname() +
                ", client=" + client.getLastname() +
                ", product='" + products + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(products, order.products) &&
                Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, client);
    }
}
