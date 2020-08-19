package app;
import dao.AbstractDao;
import dao.BookingDao;
import java.util.Scanner;

public class App {
    private static boolean exit = false;
    private static Scanner scanner = new Scanner(System.in);
    private static AbstractDao dao = new BookingDao();
    enum Menu{
        FIRST("1 - Show scoreboard"),
        SECOND("2- Show flight info"),
        THIRD("3 - Search and booking"),
        FOURTH("4 - Cancel booking"),
        FIFTH("5 - My flights"),
        SIXTH("6 - Exit");
        String description;
        Menu(String description){
            this.description = description;
        }
    }

    public void run() {
        dao.loadDataFromFile();
        while (!exit) {
            for (Menu menuItem : Menu.values()){
                System.out.println(menuItem.description);
            }
            System.out.println("Choose menu item");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1" :
                    System.out.println("Scoreboard");
                    break;
                case "2" :
                    System.out.println("Flight info");
                    break;
                case "3" :
                    System.out.println("Search and booking");
                    break;
                case "4" :
                    System.out.println("Cancel booking");
                    System.out.println(dao.getAll());
                case "5" :
                    System.out.println("My flights");
                    System.out.println(dao.getAll());
                    break;
                case "6" :
                    exit = true;
                    break;
            }
        }
    }
}
