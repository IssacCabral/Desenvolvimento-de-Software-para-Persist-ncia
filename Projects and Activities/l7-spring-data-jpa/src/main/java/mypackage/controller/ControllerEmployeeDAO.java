package mypackage.controller;

import mypackage.entity.Employee;

import javax.swing.*;
import java.util.List;

public class ControllerEmployeeDAO {
    public static void getEmployee(Employee employee){
        String cpf = JOptionPane.showInputDialog("CPF");
        Integer matricula = Integer.parseInt(JOptionPane.showInputDialog("MATRICULA"));
        String nome = JOptionPane.showInputDialog("NOME");
        String email = JOptionPane.showInputDialog("EMAIL");
        String telefone = JOptionPane.showInputDialog("TELEFONE");

        employee.setCpf(cpf);
        employee.setMatricula(matricula);
        employee.setNome(nome);
        employee.setEmail(email);
        employee.setTelefone(telefone);
    }

    public static void listEmployee(Employee employee) {
        JOptionPane.showMessageDialog(null, employee == null ? "Nenhum Funcionário encontrado" : employee);
    }

    public static void listEmployees(List<Employee> employees){
        StringBuilder sb = new StringBuilder();
        for(Employee e : employees){
            sb.append(e).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.length() == 0 ? "Nenhum Func Encontrado" : sb);
    }
}
