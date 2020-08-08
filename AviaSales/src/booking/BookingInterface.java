package booking;

import java.util.List;

public interface BookingInterface<T> {

    List<T> getAllBooking();

    void deleteBooking(T t);

    void safeBooking(T t);

    void updateBooking(T t, String[] params);
}
