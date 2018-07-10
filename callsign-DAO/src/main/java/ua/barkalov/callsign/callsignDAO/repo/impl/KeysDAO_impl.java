package ua.barkalov.callsign.callsignDAO.repo.impl;

import org.springframework.stereotype.Repository;
import ua.barkalov.callsign.callsignDAO.model.Keys;
import ua.barkalov.callsign.callsignDAO.repo.KeysDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class KeysDAO_impl implements KeysDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Keys get(Long id) {
        return entityManager.find(Keys.class, id);
    }
}
