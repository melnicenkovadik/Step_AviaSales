package dao;

import entity.Booking;

public class BookingDao extends AbstractDao<Booking> implements Dao<Booking> {
    public BookingDao() {
        super("booking.txt");
    }
}
