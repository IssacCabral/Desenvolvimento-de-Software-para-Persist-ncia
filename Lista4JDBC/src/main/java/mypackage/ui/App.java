package mypackage.ui;

import mypackage.dao.ConnectionFactory;
import mypackage.dao.EmployeeDAOJDBC;
import mypackage.dao.IEmployeeDAO;
import mypackage.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        IEmployeeDAO employeeDAO = new EmployeeDAOJDBC(ConnectionFactory.getConnection());

        // CREATE
//        Employee e = new Employee("224", 1113, "mateusin", "mateusin@hotmail.com", "99999");
//        employeeDAO.create(e);
//        // READ
//        List<Employee> employeeList = employeeDAO.listAll();
//        for(Employee employee : employeeList){
//            System.out.println(employee);
//        }
        // UPDATE

        //employeeDAO.update(1,"06555331330",5546,"Issac Cabral","issac@hotmail.com","8887776");


        //employeeDAO.delete(11);

        List<Employee> e = employeeDAO.listAll();
        for(Employee employee: e){
            System.out.println(employee);
        }

    }
}
