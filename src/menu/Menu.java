package menu;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private static boolean exit = false;
    private static String answer = "";
    private static Scanner scanner = new Scanner(System.in);
    enum MenuList{
        FIRST("Show scoreboard"),
        SECOND("show flight info"),
        THIRD("Search and booking"),
        FOURTH("Cancel booking"),
        FIFTH("My flights"),
        SIXTH("Exit");
        String description;
        MenuList(String description){
            this.description = description;
        }
    }

    public void run() {
        while (!exit) {
            for (MenuList menuItem : MenuList.values()){
                System.out.println(menuItem +" " +menuItem.description);
            }
            System.out.println("Choose menu item");
            answer = scanner.nextLine();
            switch (answer) {
                case "FIRST" :
                    break;
                case "SECOND" :
                    break;
                case "SIX" :
                    exit = true;
            }
        }
    }
}
