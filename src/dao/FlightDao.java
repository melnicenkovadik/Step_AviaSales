package dao;

import entity.Flight;

public class FlightDao extends AbstractDao<Flight> implements Dao<Flight> {
    public FlightDao() {
        super("flight.txt");
    }
}
