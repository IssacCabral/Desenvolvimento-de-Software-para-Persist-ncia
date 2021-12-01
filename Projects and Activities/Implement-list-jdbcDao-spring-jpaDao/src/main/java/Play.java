import mypackage.dao.EmployeeDAOJdbc;
import mypackage.dao.IEmployeeDAO;
import mypackage.model.Employee;
import mypackage.ui.View;

public class Play {
    public static void main(String[] args) {
//        IEmployeeDAO x = new EmployeeDAOJdbc();
//        Employee employee = new Employee("22", 22, "jk", "email", "phone");
//        x.create(employee);
//        System.out.println("ok!");
        View view = new View();
        view.run();
    }
}
