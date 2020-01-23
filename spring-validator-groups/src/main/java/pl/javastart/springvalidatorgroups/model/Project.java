package pl.javastart.springvalidatorgroups.model;

import pl.javastart.springvalidatorgroups.constraint.group.Complete;
import pl.javastart.springvalidatorgroups.constraint.group.Draft;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class Project {

    @NotNull(groups = Draft.class)
    @Size(min = 5, groups = Draft.class)
    private String title;
    @Past(groups = Draft.class)
    private Date date;
    @NotNull(groups = Complete.class)
    @Size(groups = Complete.class, min = 5)
    private String description;
    @NotNull(groups = Complete.class)
    @Size(groups = Complete.class, min = 3)
    private String owner;

    public Project() {
    }

    public Project(String title, Date date, String description, String owner) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(title, project.title) &&
                Objects.equals(date, project.date) &&
                Objects.equals(description, project.description) &&
                Objects.equals(owner, project.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description, owner);
    }
}
