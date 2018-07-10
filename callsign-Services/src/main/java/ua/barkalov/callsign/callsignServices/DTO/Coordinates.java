package ua.barkalov.callsign.callsignServices.DTO;

public class Coordinates {

    private Integer firstKeyX;
    private Integer firstKeyY;
    private Integer secondKeyX;
    private Integer secondKeyY;

    public Coordinates(Integer firstKeyX, Integer firstKeyY, Integer secondKeyX, Integer secondKeyY) {
        this.firstKeyX = firstKeyX;
        this.firstKeyY = firstKeyY;
        this.secondKeyX = secondKeyX;
        this.secondKeyY = secondKeyY;
    }

    public Integer getFirstKeyX() {
        return firstKeyX;
    }

    public void setFirstKeyX(Integer firstKeyX) {
        this.firstKeyX = firstKeyX;
    }

    public Integer getFirstKeyY() {
        return firstKeyY;
    }

    public void setFirstKeyY(Integer firstKeyY) {
        this.firstKeyY = firstKeyY;
    }

    public Integer getSecondKeyX() {
        return secondKeyX;
    }

    public void setSecondKeyX(Integer secondKeyX) {
        this.secondKeyX = secondKeyX;
    }

    public Integer getSecondKeyY() {
        return secondKeyY;
    }

    public void setSecondKeyY(Integer secondKeyY) {
        this.secondKeyY = secondKeyY;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "firstKeyX=" + firstKeyX +
                ", firstKeyY=" + firstKeyY +
                ", secondKeyX=" + secondKeyX +
                ", secondKeyY=" + secondKeyY +
                '}';
    }
}
