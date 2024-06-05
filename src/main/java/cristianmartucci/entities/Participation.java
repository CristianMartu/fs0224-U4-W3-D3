package cristianmartucci.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipation")
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

    @Column(name = "participation name")
    @Enumerated(EnumType.STRING)
    private ParticipationState participation_state;

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
