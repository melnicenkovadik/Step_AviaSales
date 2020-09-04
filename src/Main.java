import controller.BookingController;
import controller.FlightController;
import entity.Booking;
import entity.Flight;
import enums.Destinations;
import menu.Menu;
import service.BookingService;
import service.FlightService;

import java.time.Instant;
import java.util.*;

public class Main {

    private static boolean exit = false;
    private static Scanner scanner = new Scanner(System.in);
    private static FlightController flightController = new FlightController();
    private static BookingController bookingController = new BookingController();
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        Random rand = new Random();


        while (!exit) {
            Scanner scanner = new Scanner(System.in);

            menu.showMenu();
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("\nScoreboard");
                    flightController.getFlights()
                            .stream()
                            .forEach(f -> System.out.println(f));
                    break;
                case "2":
                    System.out.println("\nFlight info\n");
                    System.out.print("Enter id: ");
                    long id = scanner.nextLong();
                    Optional<Flight> flight = flightController.getFlightInfo(id);

                    System.out.println(flight.map(Flight::toString).orElse("Error flight"));
                    break;
                case "3":
                    System.out.println("\nSearch and booking");
                    System.out.print("Enter id: ");
                    long searchId = scanner.nextLong();

                    Optional<Flight> booking = flightController.getFlightInfo(searchId);

                    System.out.print("Enter name: ");
                    String name = scanner.next();

                    System.out.print("Enter surname: ");
                    String surname = scanner.next();

                    System.out.println(booking.map(b -> {
                        bookingController.addBooking(new Booking(name, surname, b));
                        return b.toString();
                    }).orElse("Error booking."));


                    break;
                case "4":
                    System.out.println("\nCancel booking");
                    System.out.println("\nPls enter booking id: ");
                    long bookingIdForRemove = scanner.nextInt();
                    bookingController.removeBookingById(bookingIdForRemove);
                    break;
                case "5":
                    System.out.println("\nMy flights");
                    String nameForSearch = scanner.nextLine();
                    String surnameForSearch = scanner.nextLine();

                    bookingController.getAllBookings()
                            .stream()
                            .filter(b -> {
                                return b.getUserName().equalsIgnoreCase(nameForSearch) && b.getUserSurname().equalsIgnoreCase(surnameForSearch);
                            })
                            .forEach(item -> {
                                System.out.println(item);
                            });
                    break;

                case "6":
                    System.out.println("\nGenerate random data...");
                    System.out.print("Enter count of flights: ");
                    int count = scanner.nextInt();

                    List<Destinations> destinationsList = new ArrayList<>(Arrays.asList(Destinations.values()));

                    for (int i = 0; i < count; i++) {
                        Collections.shuffle(destinationsList);
                        Flight newFlight = new Flight(Instant.now().plusMillis(1000 * 60 * 60 * 24), rand.nextInt(100), destinationsList.get(0));
                        flightController.saveFlight(newFlight);
                        System.out.println(newFlight);
                    }

                    break;
                case "0":
                    exit = true;
                    flightController.save();
                    bookingController.save();
                    break;


                default:
                    System.out.println("\nОшибка пункта меню.");
                    break;
            }
        }
    }
}
