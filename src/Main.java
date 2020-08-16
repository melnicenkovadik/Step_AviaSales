import dao.AbstractDao;
import dao.BookingDao;

import dao.FlightDao;
import entity.Booking;
import entity.Flight;

import enums.Destinations;
import menu.Menu;

public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.run();

        AbstractDao dao = new FlightDao();

        for (Destinations value : Destinations.values()) {
            System.out.println(value.toString());
        }

        System.out.println(dao.getAll());
    }
}
