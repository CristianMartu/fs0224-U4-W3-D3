package cristianmartucci.dao;

import cristianmartucci.entities.Event;
import cristianmartucci.exceptions.EventException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
    }

    public Event getById(String eventId) {
        Event event = em.find(Event.class, UUID.fromString(eventId));
        if (event == null) throw new EventException(UUID.fromString(eventId));
        return event;
    }

    public void delete(String eventId) {
        Event event = this.getById(eventId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(event);
        transaction.commit();
    }
}
