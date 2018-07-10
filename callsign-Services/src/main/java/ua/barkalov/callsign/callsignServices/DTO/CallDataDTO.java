package ua.barkalov.callsign.callsignServices.DTO;

public class CallDataDTO {

    private String callData;

    public CallDataDTO(String callData) {
        this.callData = callData;
    }

    public CallDataDTO() {
    }

    public String getCallData() {
        return callData;
    }

    public void setCallData(String callData) {
        this.callData = callData;
    }

    @Override
    public String toString() {
        return "CallDataDTO{" +
                "callData='" + callData + '\'' +
                '}';
    }
}
