package ua.barkalov.callsign.callsignServices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.barkalov.callsign.callsignDAO.repo.CallDataDAO;
import ua.barkalov.callsign.callsignServices.CallDataService;
import ua.barkalov.callsign.callsignServices.DTO.CallDataDTO;
import ua.barkalov.callsign.callsignServices.DTO.Coordinates;
import ua.barkalov.callsign.callsignServices.converters.CallDataConverter;

@Service
public class CallDataService_impl implements CallDataService {

    private final CallDataDAO callDataDAO;
    private final CallDataConverter callDataConverter;

    @Autowired
    public CallDataService_impl(CallDataDAO callDataDAO, CallDataConverter callDataConverter) {
        this.callDataDAO = callDataDAO;
        this.callDataConverter = callDataConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public CallDataDTO get(Long id) {
        return callDataConverter.toDto(callDataDAO.get(id));
    }

    @Override
    public String getCallsign(Coordinates coordinates) {

        String callsign = "";
        String[] tmp;

        tmp = get(coordinates.getFirstKeyX().longValue()).getCallData().split("/");
        callsign += tmp[coordinates.getFirstKeyY()].substring(0, 1);

        tmp = get(coordinates.getSecondKeyX().longValue()).getCallData().split("/");
        callsign += tmp[coordinates.getSecondKeyY()].substring(2, 3);

        return callsign;
    }
}
