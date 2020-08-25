import entity.Flight;
import enums.Destinations;
import menu.Menu;
import service.FlightService;

import java.time.Instant;
import java.util.*;

public class Main {

    private static boolean exit = false;
    private static Scanner scanner = new Scanner(System.in);
    private static FlightService service = new FlightService();
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
                    service.getFlights().stream()
                            .forEach(item -> {
                                System.out.println(item);
                            });
                    break;
                case "2":
                    System.out.println("\nFlight info\n");
                    System.out.print("Enter id: ");
                    long id = scanner.nextLong();
                    Flight flight = service.getFlightInfo(id);
                    System.out.println(flight != null ? flight : "\nДанные отсутствуют.");

                    break;
                case "3":
                    System.out.println("\nSearch and booking");
                    break;
                case "4":
                    System.out.println("\nCancel booking");
                    break;
                case "5":
                    System.out.println("\nMy flights");
                    break;

                case "6":
                    System.out.println("\nGenerate random data...");
                    System.out.print("Enter count of flights: ");
                    int count = scanner.nextInt();

                    List<Destinations> destinationsList = new ArrayList<>(Arrays.asList(Destinations.values()));

                    for (int i = 0; i < count; i++) {
                        Collections.shuffle(destinationsList);
                        Flight newFlight = new Flight(Instant.now(), rand.nextInt() * 100, destinationsList.get(0));
                        service.saveFlight(newFlight);
                        System.out.println(newFlight);
                    }

                    break;
                case "0":
                    exit = true;
                    service.saveDataToFile();
                    break;


                default:
                    System.out.println("\nОшибка пункта меню.");
                    break;
            }
        }
    }
}
