package pl.javastart.springjpaotm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_order")
    private Long id;

    private String product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order() {
    }

    public Order(String product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
                ", product='" + product + '\'' +
                ", client=" + client.getFirstname() +
                ", client=" + client.getLastname() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(product, order.product) &&
                Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, client);
    }
}
