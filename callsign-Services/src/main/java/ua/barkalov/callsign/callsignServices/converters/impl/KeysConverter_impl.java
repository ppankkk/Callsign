package ua.barkalov.callsign.callsignServices.converters.impl;

import ua.barkalov.callsign.callsignDAO.model.Keys;
import ua.barkalov.callsign.callsignServices.DTO.KeysDTO;
import ua.barkalov.callsign.callsignServices.converters.KeysConverter;

public class KeysConverter_impl implements KeysConverter {

    @Override
    public KeysDTO toDto(Keys entity) {
        return new KeysDTO(entity.getFirst_Key(), entity.getLast_Key());
    }
}
