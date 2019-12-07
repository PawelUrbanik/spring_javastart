package pl.javastart.springjtaoto.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    public static final long serialVersionUID = 1L;

    public User() {
    }

    public User(String username, String passwd, String email) {
        this.username = username;
        this.passwd = passwd;
        this.email = email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String passwd;

    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "user_details")
    private UserDetails details;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(passwd, user.passwd) &&
                Objects.equals(email, user.email) &&
                Objects.equals(details, user.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, passwd, email, details);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", email='" + email + '\'' +
                ", details=" + details +
                '}';
    }
}
