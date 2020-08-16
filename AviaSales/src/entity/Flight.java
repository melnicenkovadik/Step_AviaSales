package entity;
import enums.Destinations;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Objects;

public class Flight extends AbstractEntity<Flight> implements Serializable {
    private long id;
    private Instant dateTime;
    private int freePlaces;
    private String departure = "KIEV";

    public Flight() {
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
                ", dateTime=" + new SimpleDateFormat("dd.MM.yyyy | h:mm").format(dateTime) +
                ", freePlaces=" + freePlaces +
                ", departure='" + departure + '\'' +
                '}';
    }
}
