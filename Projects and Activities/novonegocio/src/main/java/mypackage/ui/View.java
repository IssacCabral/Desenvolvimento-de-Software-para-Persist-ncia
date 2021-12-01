package mypackage.ui;

import mypackage.Controller.ControllerJPAEmployee;
import mypackage.dao.IEmployeeDAO;
import mypackage.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class View {
    @Autowired
    private IEmployeeDAO eJpa;

    public void run(){
        while(true){
            String op = JOptionPane.showInputDialog(MenuView.MENU);

            if(op.equals("6")) break;
            switch (op){
                case "1":
                    eJpa.create(ControllerJPAEmployee.createEmployee());
                    JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
                    break;
                case "2":
                    List<Employee> employeeList = eJpa.listAll();
                    JOptionPane.showMessageDialog(null, ControllerJPAEmployee.listAllEmployee(employeeList));
                    break;
                case "3":
                    Employee employee = eJpa.findById(ControllerJPAEmployee.listEmployeeById());
                    JOptionPane.showMessageDialog(null, employee);
                    break;
                case "4":
                    eJpa.update(ControllerJPAEmployee.update());
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                    break;
                case "5":

                    JOptionPane.showMessageDialog(null, "Email alterado com sucesso!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Dados inválidos");
                    break;
            }
        }
    }
}
