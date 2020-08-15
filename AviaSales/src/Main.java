import dao.AbstractDao;
import dao.BookingDao;
import entity.Booking;
import menu.Menu;
public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.run();

        AbstractDao dao = new BookingDao();

        dao.loadDataFromFile();
        System.out.println(dao.getAll());

    }
}
