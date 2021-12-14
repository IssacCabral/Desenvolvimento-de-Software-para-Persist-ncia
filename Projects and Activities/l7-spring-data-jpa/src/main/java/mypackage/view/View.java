package mypackage.view;

import mypackage.controller.ControllerEmployeeDAO;
import mypackage.dao.EmployeeDAO;
import mypackage.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;


@EnableJpaRepositories("mypackage.dao")
@EntityScan("mypackage.entity")
@Service
public class View {
    @Autowired
    private EmployeeDAO employeeDAO;

    public void run(){
        while(true){
            String op = JOptionPane.showInputDialog(MenuView.MENU);
            String cpf;
            Employee employee;

            if(op.equals("8")) break;
            switch (op){
                case "1": //Create
                    employee = new Employee();
                    ControllerEmployeeDAO.getEmployee(employee);
                    employeeDAO.save(employee);
                    JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
                    break;
                case "2": //Atualizar por CPF
                    cpf = JOptionPane.showInputDialog("Digite o CPF do cliente a ser alterado");
                    employee = employeeDAO.findFirstByCpf(cpf);
                    ControllerEmployeeDAO.getEmployee(employee);
                    employeeDAO.save(employee);
                    break;
                case "3": //Remover por CPF
                    cpf = JOptionPane.showInputDialog("CPF");
                    employee = employeeDAO.findFirstByCpf(cpf);
                    if(employee != null){
                        employeeDAO.deleteById(employee.getId());
                    }else{
                        JOptionPane.showMessageDialog(null, "CLiente não encontrado, não foi possível remover!");
                    }
                    break;
                case "4": // Exibir por CPF
                    cpf = JOptionPane.showInputDialog("CPF");
                    employee = employeeDAO.findByCpfNamedQuery(cpf);
                    ControllerEmployeeDAO.listEmployee(employee);
                    break;
                case "5": // Exibir por ID
                    Integer id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
                    employee = employeeDAO.findById(id).orElse(null);
                    ControllerEmployeeDAO.listEmployee(employee);
                    break;
                case "6": // Exibir Todos
                    ControllerEmployeeDAO.listEmployees(employeeDAO.findAll());
                    break;
                case "7": // Exibir todos que contém determinado nome
                    String name = JOptionPane.showInputDialog("Nome");
                    ControllerEmployeeDAO.listEmployees(employeeDAO.findByNameInitBy(name));
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Entrada inválida");
                    break;
            }
        }
    }
}
