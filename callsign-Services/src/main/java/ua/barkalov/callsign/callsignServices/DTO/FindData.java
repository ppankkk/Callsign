package ua.barkalov.callsign.callsignServices.DTO;

public class FindData {
    private String data;
    private String day;

    public FindData(String data, String day) {
        this.data = data;
        this.day = day;
    }

    public FindData() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "{" +
                "data='" + data + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
