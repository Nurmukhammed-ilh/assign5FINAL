
import controllers.EmployeeController;
import data.PostgresDB;
import data.interfaces.IDB;
import entities.Employee;
import repositories.EmployeeRepositories;
import repositories.interfaces.IEmployeeRepositories;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEmployeeRepositories repo = new EmployeeRepositories(db);
        EmployeeController controller = new EmployeeController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
