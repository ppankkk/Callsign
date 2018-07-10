package ua.barkalov.callsign.callsignDAO.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "KEYS")
public class Keys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRST_KEY", nullable = false)
    private String first_Key;

    @Column(name = "SECOND_KEY", nullable = false)
    private String last_Key;

    public Keys(String first_Key, String last_Key) {
        this.first_Key = first_Key;
        this.last_Key = last_Key;
    }

    public Keys() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_Key() {
        return first_Key;
    }

    public void setFirst_Key(String first_Key) {
        this.first_Key = first_Key;
    }

    public String getLast_Key() {
        return last_Key;
    }

    public void setLast_Key(String last_Key) {
        this.last_Key = last_Key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keys keys = (Keys) o;
        return Objects.equals(first_Key, keys.first_Key) &&
                Objects.equals(last_Key, keys.last_Key);
    }

    @Override
    public int hashCode() {

        return Objects.hash(first_Key, last_Key);
    }

    @Override
    public String toString() {
        return "Keys{" +
                "id=" + id +
                ", first_Key='" + first_Key + '\'' +
                ", last_Key='" + last_Key + '\'' +
                '}';
    }
}
