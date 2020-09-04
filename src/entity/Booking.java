package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Booking extends AbstractEntity<Booking> implements Serializable {
    private long id;
    private String userName;
    private String userSurname;
    private Flight flight;

    public Booking(String userName, String userSurname, Flight flight) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.flight = flight;

        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(userName, booking.userName) &&
                Objects.equals(userSurname, booking.userSurname) &&
                Objects.equals(flight, booking.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userSurname, flight);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", flight=" + flight +
                '}';
    }
}
