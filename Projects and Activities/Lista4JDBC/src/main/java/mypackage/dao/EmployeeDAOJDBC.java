package mypackage.dao;

import mypackage.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOJDBC implements IEmployeeDAO{
    private Connection connection;

    public EmployeeDAOJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO funcionario (cpf,matricula,nome,email,telefone)" +
                     "VALUES" + "(?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1,employee.getCpf());
            stmt.setInt(2,employee.getMatricula());
            stmt.setString(3,employee.getNome());
            stmt.setString(4,employee.getEmail());
            stmt.setString(5,employee.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("Não foi possível inserior o funcionário");
        }
    }

    @Override
    public List<Employee> listAll() {
        String sql = "SELECT * FROM funcionario ORDER BY ID";
        List<Employee> employeeList = new ArrayList<>();

        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Employee employee = map(rs);
                employeeList.add(employee);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("Não foi possível carregar a lista de funcionários");
        }
        return employeeList;
    }

    @Override
    public Employee findById(int id){
        String sql = "SELECT id, cpf, matricula, nome, email, telefone " +
                     "FROM funcionario WHERE id = ?";
        Employee employee = null;

        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                employee = map(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("Não foi possível carregar o funcionário");
        }
        return employee;
    }

    @Override
    public void update(Integer id,String cpf,Integer matricula,String nome,String email,String telefone){
        String sql = "UPDATE funcionario SET cpf = ?, matricula = ?, nome = ?, email = ?, telefone = ? WHERE id = ?";

        try{
            PreparedStatement stms = this.connection.prepareStatement(sql);
            stms.setString(1, cpf);
            stms.setInt(2, matricula);
            stms.setString(3, nome);
            stms.setString(4, email);
            stms.setString(5, telefone);
            stms.setInt(6, id);

            stms.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("Não foi possível atualizar");
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";

        try{
            PreparedStatement stms = this.connection.prepareStatement(sql);
            stms.setInt(1,id);
            stms.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("Não foi possível deletar o funcionario");
        }
    }

    private Employee map(ResultSet rs) throws SQLException{
        Employee employee = new Employee(
            rs.getInt("id"),
            rs.getString("cpf"),
            rs.getInt("matricula"),
            rs.getString("nome"),
            rs.getString("email"),
            rs.getString("telefone")
        );
        return employee;
    }

}
