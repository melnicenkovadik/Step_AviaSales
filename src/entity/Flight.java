package entity;
import enums.Destinations;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Flight extends AbstractEntity<Flight> implements Serializable {
    private long id;
    private Instant dateTime;
    private int freePlaces;
    private String departure = "KIEV";
    private Destinations destination;

    public Flight() {
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public Flight(Instant dateTime, int freePlaces, Destinations destination) {
        this.dateTime = dateTime;
        this.freePlaces = freePlaces;
        this.destination = destination;
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public Destinations getDestination() {
        return destination;
    }

    public void setDestination(Destinations destination) {
        this.destination = destination;
    }

    public long getId() {
        return id;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", freePlaces=" + freePlaces +
                ", departure='" + departure + '\'' +
                ", destination=" + destination +
                '}';
    }
}
