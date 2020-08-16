package test;


import entity.Flight;
import junit.framework.TestResult;
import org.junit.Test;
import service.FlightService;

import javax.lang.model.type.NullType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestServiceF {
    private static java.lang.Object Object;

    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        List<Flight> result = flightService.getFlights();
        if (result == Object) {
            System.out.println("zbs");

        } else {
            System.out.println("Boroda");
        }

    }
}
