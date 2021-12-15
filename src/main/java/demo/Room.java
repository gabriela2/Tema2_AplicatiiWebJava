package demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "seats")
    private int seats;

    @OneToMany(mappedBy = "room")
    @JsonIgnoreProperties("room")
    private Set<Track> tracks;

    public Room(){

    }

    public Room(String name, String address, int seats) {
        this.name = name;
        this.address = address;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getSeats() {
        return seats;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void update(Room room){
        this.name = room.name;
        this.address = room.address;
        this.seats = room.seats;
    }
    public void addTrack(Track track){
        tracks.add(track);
    }

    public void removeTrack(Track track){
        tracks.remove(track);
    }
}
