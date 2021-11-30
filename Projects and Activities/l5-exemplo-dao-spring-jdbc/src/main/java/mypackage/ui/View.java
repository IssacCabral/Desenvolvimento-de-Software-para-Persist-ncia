package mypackage.ui;

import mypackage.dao.IEmployeeDAO;
import mypackage.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class View {
    @Autowired
    private IEmployeeDAO employeeDAO;

    private Employee createEmployee(){
        Employee e = null;
        try{
            String[] tokens = JOptionPane.showInputDialog("Digite os dados do funcionário " +
                    "na ordem " +
                    "(Cpf, Matrícula, Nome, Email, Telefone): ")
                    .split(", ");
            e = new Employee(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]);
        } catch (IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Fail: provavelmente você " +
                    "esqueceu algum parâmetro");
        }
        return e;
    }

    private void listEmployeeById(){
        List<Employee> employeeList = employeeDAO.listAll();
        String aux = showListEmployee(employeeList);
        String op = JOptionPane.showInputDialog(null, aux + "Insira o ID desejado");
        Employee e = employeeDAO.findById(Integer.parseInt(op));
        JOptionPane.showMessageDialog(null, e);
    }

    private String showListEmployee(List<Employee> employeeList){
        String aux = "";
        for(Employee employee : employeeList){
            aux += employee + "\n";
        }
        return aux;
    }

    private String[] updateEmployee(){
        String[] tokens = JOptionPane.showInputDialog(null, "Digite os " +
                "dados de quem deseja atualizar: \n" +
                "id, cpf, matricula, nome, email, telefone")
                .split(", ");
        return tokens;
    }

    private int deleteEm(){
        String id = JOptionPane.showInputDialog(null, "Digite o id que deseja deletar");
        return Integer.parseInt(id);
    }

    public void run() throws Exception {
        while(true){
            String op = JOptionPane.showInputDialog(Menu.MENU);

            if(op.equals("end")) {
                break;
            }
            switch (op){
                case "create":
                    Employee e = createEmployee();
                    employeeDAO.create(e);
                    break;
                case "list":
                    List<Employee> employeeList = employeeDAO.listAll();
                    JOptionPane.showMessageDialog(null, showListEmployee(employeeList));
                    break;
                case "listbyid":
                    listEmployeeById();
                    break;
                case "update":
                    String[] tokens = updateEmployee();
                    employeeDAO.update(
                            Integer.parseInt(tokens[0]),
                            tokens[1],
                            Integer.parseInt(tokens[2]),
                            tokens[3], tokens[4], tokens[5]);
                    break;
                case "delete":
                    employeeDAO.delete(deleteEm());
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Dados inválidos");
                    break;
            }
        }
    }
}
