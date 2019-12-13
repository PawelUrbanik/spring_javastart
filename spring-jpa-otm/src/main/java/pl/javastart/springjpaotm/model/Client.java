package pl.javastart.springjpaotm.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
    public static final long versionUID = 1L;

    public Client() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private Long id;

    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private List<Order> orders;

    public Client(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstname, client.firstname) &&
                Objects.equals(lastname, client.lastname) &&
                Objects.equals(orders, client.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, orders);
    }
}
