package menu;
public class Menu {
    enum MenuList{
        FIRST("\n1. - Show scoreboard"),
        SECOND("2. - Show flight info"),
        THIRD("3. - Search and booking"),
        FOURTH("4. - Cancel booking"),
        FIFTH("5. - My flights"),
        SIXTH("0. - Exit");
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
