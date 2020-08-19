import dao.AbstractDao;
import dao.BookingDao;
import app.App;
public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();

        AbstractDao dao = new BookingDao();

        dao.loadDataFromFile();
        System.out.println(dao.getAll());

    }


}
