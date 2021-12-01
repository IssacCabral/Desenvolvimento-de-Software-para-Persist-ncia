package mypackage.Controller;

import mypackage.entity.Employee;

import javax.swing.*;
import java.util.List;

public class ControllerJPAEmployee {
    public static Employee createEmployee(){
        Employee e = null;

        String cpf = JOptionPane.showInputDialog("CPF");
        Integer matricula = Integer.parseInt(JOptionPane.showInputDialog("MATRICULA"));
        String nome = JOptionPane.showInputDialog("NOME");
        String email = JOptionPane.showInputDialog("EMAIL");
        String telefone = JOptionPane.showInputDialog("TELEFONE");

        e = new Employee(cpf, matricula, nome, email, telefone);
        return e;
    }

    public static String listAllEmployee(List<Employee> employeeList){
        String aux = "";
        for(Employee e : employeeList){
            aux += e + "\n";
        }
        return aux;
    }

    public static Integer listEmployeeById(){
        Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID"));
        return id;
    }

    public static Employee update(){
        Integer id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String cpf = JOptionPane.showInputDialog("CPF");
        Integer matricula = Integer.parseInt(JOptionPane.showInputDialog("MATRICULA"));
        String nome = JOptionPane.showInputDialog("NOME");
        String email = JOptionPane.showInputDialog("EMAIL");
        String telefone = JOptionPane.showInputDialog("TELEFONE");

        Employee employee = new Employee(id, cpf, matricula, nome, email, telefone);
        return employee;
    }

    public static Integer deleteEmployee(){
        Integer id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        return id;
    }
}
