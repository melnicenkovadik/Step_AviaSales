import entity.Flight;
import menu.Menu;
import service.FlightService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static boolean exit = false;
    private static Scanner scanner = new Scanner(System.in);
    private static FlightService service = new FlightService();
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        while (!exit) {
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
                    System.out.println(flight != null ? flight : "Данные отсутствуют.");
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
                    exit = true;
                    break;
            }
        }
    }

    private static boolean exit() {
        System.out.println("Press 0 to return to menu");
        return scanner.nextLine().equals("0");
    }
}
