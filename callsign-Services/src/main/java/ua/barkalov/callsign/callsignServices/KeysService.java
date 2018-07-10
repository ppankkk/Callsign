package ua.barkalov.callsign.callsignServices;

import ua.barkalov.callsign.callsignServices.DTO.Coordinates;
import ua.barkalov.callsign.callsignServices.DTO.KeysDTO;

public interface KeysService {

    KeysDTO get(Long id);
    Coordinates getCoordinates(KeysDTO keysDTO, String data);
}
