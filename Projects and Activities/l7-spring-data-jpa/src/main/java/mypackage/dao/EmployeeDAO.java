package mypackage.dao;

import mypackage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    public Employee findFirstByCpf(String cpf);
    public List<Employee> findFirstByNome(String nome);

    @Query(name = "employeeByCpf")
    public Employee findByCpfNamedQuery(String cpf);

    @Query("select e from Employee e where e.nome like :nome%")
    public List<Employee> findByNameInitBy(String nome);
}
