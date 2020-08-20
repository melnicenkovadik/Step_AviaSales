import dao.AbstractDao;
import dao.BookingDao;
import menu.Menu;

import java.util.Scanner;

public class Main {

    private static boolean exit = false;
    private static Scanner scanner = new Scanner(System.in);
    private static AbstractDao dao = new BookingDao();
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        dao.loadDataFromFile();
        while (!exit) {
            menu.showMenu();
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Scoreboard");
                    if(exit()) break;
                case "2":
                    System.out.println("Flight info");
                    if(exit()) break;
                case "3":
                    System.out.println("Search and booking");
                    if(exit()) break;
                case "4":
                    System.out.println("Cancel booking");
                    System.out.println(dao.getAll());
                    if(exit()) break;
                case "5":
                    System.out.println("My flights");
                    System.out.println(dao.getAll());
                    if(exit()) break;
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
