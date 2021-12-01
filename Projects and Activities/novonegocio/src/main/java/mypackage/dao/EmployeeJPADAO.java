package mypackage.dao;

import mypackage.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class EmployeeJPADAO implements IEmployeeDAO{

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
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Employee> listAll() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        List<Employee> l = em.createQuery("from funcionario",
                       Employee.class).getResultList();
        return l;
    }

    @Override
    public Employee findById(int id) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        return em.find(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.merge(employee);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    @Override
    public void delete(int id) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            em.remove(em.find(Employee.class, id));
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
