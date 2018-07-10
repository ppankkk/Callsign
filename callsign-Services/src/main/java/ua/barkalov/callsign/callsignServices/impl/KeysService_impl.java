package ua.barkalov.callsign.callsignServices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.barkalov.callsign.callsignDAO.repo.KeysDAO;
import ua.barkalov.callsign.callsignServices.DTO.Coordinates;
import ua.barkalov.callsign.callsignServices.DTO.KeysDTO;
import ua.barkalov.callsign.callsignServices.KeysService;
import ua.barkalov.callsign.callsignServices.converters.KeysConverter;

@Service
public class KeysService_impl implements KeysService {

    private final KeysDAO keysDAO;
    private final KeysConverter keysConverter;

    @Autowired
    public KeysService_impl(KeysDAO keysDAO, KeysConverter keysConverter) {
        this.keysDAO = keysDAO;
        this.keysConverter = keysConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public KeysDTO get(Long id) {
        return keysConverter.toDto(keysDAO.get(id));
    }

    @Override
    public Coordinates getCoordinates(KeysDTO keysDTO, String data) {

        String first_key = keysDTO.getFirst_Key().toUpperCase();
        String last_key = keysDTO.getLast_Key().toUpperCase();

        String inputData = data.toUpperCase();

        return new Coordinates( first_key.indexOf(inputData.charAt(0)),
                                last_key.indexOf(inputData.charAt(1)),
                                first_key.indexOf(inputData.charAt(2)),
                                last_key.indexOf(inputData.charAt(3)));
    }
}
