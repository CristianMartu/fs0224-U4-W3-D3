package cristianmartucci.dao;

import cristianmartucci.entities.Person;
import cristianmartucci.exceptions.EventException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
    }

    public Person getById(String id) {
        Person person = em.find(Person.class, UUID.fromString(id));
        if (person == null) throw new EventException(UUID.fromString(id));
        return person;
    }

    public void delete(String id) {
        Person person = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(person);
        transaction.commit();
    }
}
