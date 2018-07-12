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

        CallDataDTO callDataDTO;
        Integer intId = coordinates.getFirstKeyX();
        Long id = intId.longValue();
        callDataDTO = get(id);

        System.out.println(intId);
        System.out.println(id);
        System.out.println(callDataDTO.toString());


        tmp = get(coordinates.getFirstKeyX().longValue()).getCallData().split("/");

        for (int i = 0; i < tmp.length; i++) {
            System.out.println(i + " " + tmp[i]);
        }

        System.out.println(coordinates.toString());

        callsign += tmp[coordinates.getFirstKeyY()].substring(0, 2);

        System.out.println(callsign);

        tmp = get(coordinates.getSecondKeyX().longValue()).getCallData().split("/");
        callsign += tmp[coordinates.getSecondKeyY()].substring(2, 4);

        return callsign;
    }
}
