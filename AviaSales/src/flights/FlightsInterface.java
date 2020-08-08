package flights;

import java.util.List;

public interface FlightsInterface<T> {
    List<T> getAllFlights();

    void deleteFlight(T t);

    void safeFlight(T t);

    void updateFlights(T t, String[] params);
}
