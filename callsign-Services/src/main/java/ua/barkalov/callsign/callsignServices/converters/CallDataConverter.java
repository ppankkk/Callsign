package ua.barkalov.callsign.callsignServices.converters;

import ua.barkalov.callsign.callsignDAO.model.CallData;
import ua.barkalov.callsign.callsignServices.DTO.CallDataDTO;

public interface CallDataConverter {

    CallDataDTO toDto(CallData entity);
}
