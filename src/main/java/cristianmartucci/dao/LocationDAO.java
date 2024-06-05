package cristianmartucci.dao;

import cristianmartucci.entities.Location;
import cristianmartucci.exceptions.EventException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
    }

    public Location getById(String id) {
        Location location = em.find(Location.class, UUID.fromString(id));
        if (location == null) throw new EventException(UUID.fromString(id));
        return location;
    }

    public void delete(String id) {
        Location location = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(location);
        transaction.commit();
    }
}
