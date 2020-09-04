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
                .filter(i -> Duration.between(Instant.now(), i.getDateTime()).toMillis() <= 86400000 && Duration.between(Instant.now(), i.getDateTime()).toMillis() >= 0)
                .collect(Collectors.toList());
    }

    public Optional<Flight> getFlightInfo(long id) {
        return this.flightDao.getAll().stream()
                .filter(f -> f.getId() == id)
                .findAny();
    }

    public Optional<Flight> saveFlight(Flight flight) {
        if (flight != null) {
            return Optional.ofNullable(this.flightDao.save(flight));
        }
        return Optional.empty();
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

    public void saveDataToFile() {
        this.flightDao.saveDataToFile();
    }
}
