package ua.barkalov.callsign.callsignServices.converters;

import ua.barkalov.callsign.callsignDAO.model.Keys;
import ua.barkalov.callsign.callsignServices.DTO.KeysDTO;

public interface KeysConverter {

    KeysDTO toDto(Keys entity);
}
