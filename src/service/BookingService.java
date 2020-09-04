package service;

import dao.AbstractDao;
import dao.BookingDao;
import entity.Booking;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public class BookingService {
    AbstractDao<Booking> bookingDao = new BookingDao();

    public Optional<Booking> addBooking(Booking booking) {
        return Optional.ofNullable(bookingDao.save(booking));
    }

    public boolean removeBooking(Booking booking) {
        return bookingDao.delete(booking);
    }

    public boolean removeBookingById(long id) {
        return bookingDao.getAll().stream()
                .filter(f -> f.getId() == id)
                .map(f -> bookingDao.delete(f))
                .findFirst()
                .orElse(false);
    }

    public List<Booking> getAllBookings() {
        return bookingDao.getAll();
    }

    public void saveAll() {
        bookingDao.saveDataToFile();
    }
}
