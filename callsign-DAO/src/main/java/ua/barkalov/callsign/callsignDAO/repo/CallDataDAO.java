package ua.barkalov.callsign.callsignDAO.repo;

import ua.barkalov.callsign.callsignDAO.model.CallData;

public interface CallDataDAO {

    CallData get(Long id);
}
