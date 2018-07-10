package ua.barkalov.callsign.callsignDAO.repo.impl;

import org.springframework.stereotype.Repository;
import ua.barkalov.callsign.callsignDAO.model.CallData;
import ua.barkalov.callsign.callsignDAO.repo.CallDataDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CallDataDAO_impl implements CallDataDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CallData get(Long id) {
        return entityManager.find(CallData.class, id);
    }
}
