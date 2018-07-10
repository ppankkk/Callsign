package ua.barkalov.callsign.callsignServices.DTO;

public class KeysDTO {

    private String first_Key;
    private String last_Key;

    public KeysDTO(String first_Key, String last_Key) {
        this.first_Key = first_Key;
        this.last_Key = last_Key;
    }

    public KeysDTO() {
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
    public String toString() {
        return "KeysDTO{" +
                "first_Key='" + first_Key + '\'' +
                ", last_Key='" + last_Key + '\'' +
                '}';
    }
}
