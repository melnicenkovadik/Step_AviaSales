package controller;

import entity.Booking;
import entity.Flight;
import service.FlightService;

import java.util.List;
import java.util.Optional;

public class FlightController {
    private FlightService service = new FlightService();

    public List<Flight> getFlights() {
        return service.getFlights();
    }

    public Optional<Flight> getFlightInfo(long id) {
        return service.getFlightInfo(id);
    }

    public Optional<Flight> saveFlight(Flight flight) {
        return service.saveFlight(flight);
    }

    public void save() {
        service.saveDataToFile();
    }

}
