package cristianmartucci.dao;

import cristianmartucci.entities.Participation;
import cristianmartucci.exceptions.EventException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class ParticipationDAO {
    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation participation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(participation);
        transaction.commit();
    }

    public Participation getById(String id) {
        Participation participation = em.find(Participation.class, UUID.fromString(id));
        if (participation == null) throw new EventException(UUID.fromString(id));
        return participation;
    }

    public void delete(String id) {
        Participation participation = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(participation);
        transaction.commit();
    }
}
