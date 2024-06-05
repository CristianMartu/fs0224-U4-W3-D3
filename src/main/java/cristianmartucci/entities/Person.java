package cristianmartucci.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate year_of_birth;
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @OneToMany(mappedBy = "person")
    private List<Participation> participationList;

    public Person() {

    }

    public Person(String name, String surname, String email, LocalDate year_of_birth, GenderType gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.year_of_birth = year_of_birth;
        this.gender = gender;
        this.participationList = participationList;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(LocalDate year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", year_of_birth=" + year_of_birth +
                ", gender=" + gender +
                '}';
    }
}
