package controller;

import entity.Booking;
import service.BookingService;

import java.util.List;
import java.util.Optional;

public class BookingController {
    private BookingService service = new BookingService();

    public Optional<Booking> addBooking(Booking booking) {
        return service.addBooking(booking);
    }

    public boolean removeBookingById(long id) {
        return service.removeBookingById(id);
    }


    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }

    public void save() {
        service.saveAll();
    }
}
