package pl.javastart.springmvcdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TimeData {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    public TimeData() {
    }

    public TimeData(String firstName, String lastName, Integer hours, Integer minutes, Integer seconds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "TimeData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeData timeData = (TimeData) o;
        return Objects.equals(id, timeData.id) &&
                Objects.equals(firstName, timeData.firstName) &&
                Objects.equals(lastName, timeData.lastName) &&
                Objects.equals(hours, timeData.hours) &&
                Objects.equals(minutes, timeData.minutes) &&
                Objects.equals(seconds, timeData.seconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, hours, minutes, seconds);
    }
}
