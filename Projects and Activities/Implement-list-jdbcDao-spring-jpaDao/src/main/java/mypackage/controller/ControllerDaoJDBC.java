package mypackage.controller;

import mypackage.model.Employee;

import javax.swing.*;
import java.util.List;

public class ControllerDaoJDBC {
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

    public static String[] updateName(){
        String id = JOptionPane.showInputDialog("Qual ID deseja alterar?");
        String nome = JOptionPane.showInputDialog("Qual o novo nome?");
        String[] idName = new String[2];
        idName[0] = id;
        idName[1] = nome;
        return idName;
    }

    public static String[] updateEmail(){
        String id = JOptionPane.showInputDialog("Qual ID deseja alterar?");
        String email = JOptionPane.showInputDialog("Qual o novo email?");
        String[] idEmail = new String[2];
        idEmail[0] = id;
        idEmail[1] = email;
        return idEmail;
    }

    public static String[] updatePhone(){
        String id = JOptionPane.showInputDialog("Qual ID deseja alterar?");
        String phone = JOptionPane.showInputDialog("Qual o novo phone");
        String[] idPhone = new String[2];
        idPhone[0] = id;
        idPhone[1] = phone;
        return idPhone;
    }

    public static Integer deleteEmployee(){
        Integer id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        return id;
    }
}
