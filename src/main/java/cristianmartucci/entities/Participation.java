package cristianmartucci.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "participation")
public class Participation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Enumerated(EnumType.STRING)
    private ParticipationState participation_state;

    public Participation() {
    }

    public Participation(ParticipationState participation_state, Event event, Person person) {
        this.participation_state = participation_state;
        this.event = event;
        this.person = person;
    }

    public UUID getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ParticipationState getParticipation_state() {
        return participation_state;
    }

    public void setParticipation_state(ParticipationState participation_state) {
        this.participation_state = participation_state;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                ", participation_state=" + participation_state +
                '}';
    }
}
