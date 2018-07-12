package ua.barkalov.callsign.callsignServices.converters.impl;

import org.springframework.stereotype.Component;
import ua.barkalov.callsign.callsignDAO.model.CallData;
import ua.barkalov.callsign.callsignServices.DTO.CallDataDTO;
import ua.barkalov.callsign.callsignServices.converters.CallDataConverter;

@Component
public class CallDataConverter_impl implements CallDataConverter {

    @Override
    public CallDataDTO toDto(CallData entity) {

        return new CallDataDTO(entity.getCallData());
    }
}
