package ua.barkalov.callsign.callsignServices;

import ua.barkalov.callsign.callsignServices.DTO.CallDataDTO;
import ua.barkalov.callsign.callsignServices.DTO.Coordinates;

public interface CallDataService {

    CallDataDTO get(Long id);
    String getCallsign(Coordinates coordinates);
}
