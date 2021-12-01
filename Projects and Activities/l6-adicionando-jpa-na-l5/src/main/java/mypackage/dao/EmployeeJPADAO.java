package mypackage.dao;

import mypackage.model.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Repository
@Primary
public class EmployeeJPADAO implements IEmployeeDAO{

    public static void main(String[] args) {
        Employee employee = new Employee("cpf2", 6098, "Jpa", "email", "phone");
    }

    @Override
    public void create(Employee employee) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(employee);
            tx.commit();
            System.out.println("Cheguei aqui");
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Employee> listAll() {
        return null;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void update(Integer id, String cpf, Integer matricula, String nome, String email, String telefone) {

    }

    @Override
    public void delete(int id) {

    }
}
