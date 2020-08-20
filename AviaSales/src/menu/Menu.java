package menu;
public class Menu {
    enum MenuList{
        FIRST("1. - Show scoreboard"),
        SECOND("2. - Show flight info"),
        THIRD("3. - Search and booking"),
        FOURTH("4. - Cancel booking"),
        FIFTH("5. - My flights"),
        SIXTH("6. - Exit");
        String description;
        MenuList(String description){
            this.description = description;
        }
    }

    public void showMenu() {
        for (MenuList menuItem : MenuList.values()){
            System.out.println(menuItem.description);
        }
    }
}
