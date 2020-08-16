package entity;

import java.io.Serializable;
import java.util.List;

public class Booking extends AbstractEntity<Booking> implements Serializable {
    private String userName;
    private String userSurname;
    private Flight flight;
}
