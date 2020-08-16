package service;

import dao.AbstractDao;
import dao.BookingDao;
import dao.FlightDao;
import entity.Booking;
import entity.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService {
    AbstractDao<Booking> bookingDao = new BookingDao();
    AbstractDao<Flight> flightDao = new FlightDao();

    @Test
    public List<Flight> getFlights() {
        return this.flightDao.getAll()
                .stream()
                .filter(i -> Duration.between(Instant.now(), i.getDateTime()).toHours() <= 24)
                .collect(Collectors.toList());
    }

    @Test
    public Flight getFlightInfo(long id) {
        return this.flightDao.getAll().stream()
                .filter(f -> f.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Test
    public Flight saveFlight(Flight flight) {
        if (flight != null) {
            return this.flightDao.save(flight);
        }
        return null;
    }

    @Test
    public boolean deleteFlight(Flight flight) {
        return this.flightDao.delete(flight);
    }

    @Test
    public Optional<Flight> deleteFlightById(long id) {
        return this.flightDao.getAll()
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst();
    }
}
