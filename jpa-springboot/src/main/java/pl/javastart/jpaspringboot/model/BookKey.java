package pl.javastart.jpaspringboot.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookKey implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long ids;

    public BookKey() {
    }

    public Long getId() {
        return ids;
    }

    public void setId(Long id) {
        this.ids = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookKey bookKey = (BookKey) o;
        return Objects.equals(ids, bookKey.ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids);
    }
}
