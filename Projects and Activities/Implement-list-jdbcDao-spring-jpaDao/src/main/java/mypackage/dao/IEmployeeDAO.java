package mypackage.dao;

import mypackage.model.Employee;

import java.util.List;


public interface IEmployeeDAO {
    public void create(Employee employee);
    public List<Employee>listAll();
    public Employee findById(int id);
    public void updateName(int id, String name);
    public void updateEmail(int id, String email);
    public void updatePhone(int id, String phone);
    public void delete(int id);
}
