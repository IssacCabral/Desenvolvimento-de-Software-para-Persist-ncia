package mypackage.ui;

import mypackage.controller.ControllerDaoJDBC;
import mypackage.dao.ConnectionFactory;
import mypackage.dao.EmployeeDAOJdbc;
import mypackage.dao.IEmployeeDAO;
import mypackage.model.Employee;

import javax.swing.*;
import java.util.List;

public class View {
    IEmployeeDAO employeeDAOJdbc = new EmployeeDAOJdbc();

    public void run(){
        while(true){
            String op = JOptionPane.showInputDialog(MenuView.MENU);

            if(op.equals("8")) break;
            switch (op){
                case "1":
                    employeeDAOJdbc.create(ControllerDaoJDBC.createEmployee());
                    JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
                    break;
                case "2":
                    List<Employee> employeeList = employeeDAOJdbc.listAll();
                    JOptionPane.showMessageDialog(null, ControllerDaoJDBC.listAllEmployee(employeeList));
                    break;
                case "3":
                    Employee employee = employeeDAOJdbc.findById(ControllerDaoJDBC.listEmployeeById());
                    JOptionPane.showMessageDialog(null, employee);
                    break;
                case "4":
                    String[] idName = ControllerDaoJDBC.updateName();
                    Integer id = Integer.parseInt(idName[0]);
                    String name = idName[1];

                    employeeDAOJdbc.updateName(id, name);
                    JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
                    break;
                case "5":
                    String[] idEmail = ControllerDaoJDBC.updateEmail();
                    id = Integer.parseInt(idEmail[0]);
                    String email = idEmail[1];

                    employeeDAOJdbc.updateEmail(id, email);
                    JOptionPane.showMessageDialog(null, "Email alterado com sucesso!");
                    break;
                case "6":
                    String[] idPhone = ControllerDaoJDBC.updatePhone();
                    id = Integer.parseInt(idPhone[0]);
                    String phone = idPhone[1];

                    employeeDAOJdbc.updatePhone(id, phone);
                    JOptionPane.showMessageDialog(null, "Phone alterado com sucesso!");
                    break;
                case "7":
                    employeeDAOJdbc.delete(ControllerDaoJDBC.deleteEmployee());
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Dados inválidos");
                    break;
            }
        }
    }
}
