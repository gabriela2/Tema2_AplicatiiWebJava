package demo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "attendee", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "track_id"))
    private Set<Track> tracks;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(){

    }
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track){
        tracks.add(track);
    }

    public void removeTrack(Track track){
        tracks.remove(track);
    }

    public void update(Person person){
        this.firstName = person.firstName;
        this.lastName = person.lastName;
    }

}
