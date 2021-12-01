package mypackage.dao;

import mypackage.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    public void create(Employee employee);
    public List<Employee> listAll();
    public Employee findById(int id);
    public void update(Employee employee);
    public void delete(int id);
}
