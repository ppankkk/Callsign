package ua.barkalov.callsign.callsignDAO.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CALL_NAMES")
public class CallData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CALL_DATA", nullable = false)
    private String callData;

    public CallData(String callData) {
        this.callData = callData;
    }

    public CallData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallData() {
        return callData;
    }

    public void setCallData(String callData) {
        this.callData = callData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallData callData1 = (CallData) o;
        return Objects.equals(callData, callData1.callData);
    }

    @Override
    public int hashCode() {

        return Objects.hash(callData);
    }

    @Override
    public String toString() {
        return "CallData{" +
                "id=" + id +
                ", callData='" + callData + '\'' +
                '}';
    }
}
