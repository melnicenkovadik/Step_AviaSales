package service;

import dao.AbstractDao;
import dao.FlightDao;
import entity.Flight;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService {
    AbstractDao<Flight> flightDao = new FlightDao();

    public List<Flight> getFlights() {
        return this.flightDao.getAll()
                .stream()
                .filter(i -> Duration.between(Instant.now(), i.getDateTime()).toHours() <= 24)
                .collect(Collectors.toList());
    }

    public Flight getFlightInfo(long id) {
        return this.flightDao.getAll().stream()
                .filter(f -> f.getId() == id)
                .findAny()
                .orElse(null);
    }

    public Flight saveFlight(Flight flight) {
        if (flight != null) {
            return this.flightDao.save(flight);
        }
        return null;
    }

    public boolean deleteFlight(Flight flight) {
        return this.flightDao.delete(flight);
    }

    public Optional<Flight> deleteFlightById(long id) {
        return this.flightDao.getAll()
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst();
    }
}
