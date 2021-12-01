package mypackage.dao;

import mypackage.model.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface IEmployeeDAOSpring {
    public void create(Employee employee);
    public List<Employee>listAll();
    public Employee findById(int id);
    public void updateName(int id, String name);
    public void updateEmail(int id, String email);
    public void updatePhone(int id, String phone);
    public void delete(int id);
}
