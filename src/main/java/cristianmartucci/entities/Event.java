package cristianmartucci.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    @Column(name = "event date")
    private LocalDate event_date;
    private String description;
    @Column(name = "event type")
    @Enumerated(EnumType.STRING)
    private EventType event_type;
    @Column(name = "max people")
    private int max_people;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Event() {
    }

    public Event(String title, LocalDate event_date, String description, EventType event_type, int max_people, Location location) {
        this.title = title;
        this.event_date = event_date;
        this.description = description;
        this.event_type = event_type;
        this.max_people = max_people;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEvent_type() {
        return event_type;
    }

    public void setEvent_type(EventType event_type) {
        this.event_type = event_type;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", event_date=" + event_date +
                ", description='" + description + '\'' +
                ", event_type=" + event_type +
                ", max_people=" + max_people +
                ", location=" + location +
                '}';
    }
}


