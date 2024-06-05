package cristianmartucci;

import cristianmartucci.dao.EventDAO;
import cristianmartucci.dao.LocationDAO;
import cristianmartucci.entities.Event;
import cristianmartucci.entities.EventType;
import cristianmartucci.entities.Location;
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

        Location location = new Location("Teatro Ariston", "Sanremo");
        ld.save(location);

        LocalDate date = LocalDate.of(2024, 5, 7);
        Event event = new Event("Eurovision Song Contest 2024", date, "L'Eurovision Song Contest 2024 è stata la 68ª edizione dell'annuale concorso canoro, vinta dal cantante svizzero Nemo con la canzone The Code.", EventType.PRIVATO, 13700, location);
        ed.save(event);

        try {
            Event eventType = ed.getById("6e826523-0b78-49dd-9908-5d3f544f0b1b");
            System.out.println(eventType);
        } catch (EventException error) {
            System.out.println(error.getMessage());
        }

//        Event event2 = new Event("Festival di Sanremo 2024", LocalDate.parse("2024-02-06"), "Il settantaquattresimo Festival di Sanremo si è svolto al Teatro Ariston di Sanremo. L'edizione è stata vinta da Angelina Mango con il brano La noia.", EventType.PRIVATO, 3000);
//        Event event3 = new Event("Karetera", LocalDate.parse("2024-02-18"), "Evento pubblico", EventType.PUBBLICO, 2000);
//        Event event4 = new Event("Run 5.30", LocalDate.parse("2024-06-06"), "Evento pubblico", EventType.PUBBLICO, 3000);


//        ed.save(event2);
//        ed.save(event3);
//        ed.save(event4);

//
//        try {
//            ed.delete(1);
//        } catch (EventException error) {
//            System.out.println(error.getMessage());
//        }

        em.close();
        emf.close();
    }
}
