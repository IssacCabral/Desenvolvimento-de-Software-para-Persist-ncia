package mypackage.dao;

import mypackage.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    public void create(Employee employee);
    public List<Employee> listAll();
    public Employee findById(int id);
    public void update(Integer id,String cpf,Integer matricula,String nome,String email,String telefone);
    public void delete(int id);
}
