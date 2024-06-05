package cristianmartucci;

import cristianmartucci.dao.EventDAO;
import cristianmartucci.dao.LocationDAO;
import cristianmartucci.dao.ParticipationDAO;
import cristianmartucci.dao.PersonDAO;
import cristianmartucci.entities.*;
import cristianmartucci.exceptions.EventException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myEvent");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonDAO personDao = new PersonDAO(em);
        ParticipationDAO pd = new ParticipationDAO(em);

        Location location = new Location("Teatro Ariston", "Sanremo");
//        ld.save(location);

        LocalDate date = LocalDate.of(2024, 5, 7);
        Event event = new Event("Eurovision Song Contest 2024", date, "L'Eurovision Song Contest 2024 è stata la 68ª edizione dell'annuale concorso canoro, vinta dal cantante svizzero Nemo con la canzone The Code.", EventType.PRIVATO, 13700, location);
//        ed.save(event);

        Person geralt = new Person("Geralt", "Of Rivia", "geraltOfRivia@gmail.com", LocalDate.parse("1964-02-06"), GenderType.MASCHIO);
//        personDao.save(geralt);


        Event eventFromDb = ed.getById("1cd33559-a2eb-411d-b6bd-e3c15f9f80ad");
        Person geraltFromDb = personDao.getById("d02dca79-e0fb-479a-9e45-459d41f7d93f");
        Participation participation = new Participation(ParticipationState.CONFERMATA, eventFromDb, geraltFromDb);
//        pd.save(participation);

        try {
            Event eventType = ed.getById("6e826523-0b78-49dd-9908-5d3f544f0b1b");
            System.out.println(eventType);
        } catch (EventException error) {
            System.out.println(error.getMessage());
        }


        em.close();
        emf.close();
    }
}
