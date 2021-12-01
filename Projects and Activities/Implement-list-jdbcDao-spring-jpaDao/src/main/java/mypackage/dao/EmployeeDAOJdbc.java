package mypackage.dao;

import mypackage.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOJdbc implements IEmployeeDAO{

    private Employee map(ResultSet rs) throws SQLException{
        Employee employe = new Employee(
            rs.getInt("id"),
            rs.getString("cpf"),
            rs.getInt("matricula"),
            rs.getString("nome"),
            rs.getString("email"),
            rs.getString("telefone")
        );
        return employe;
    }

    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO funcionario (cpf,matricula,nome,email,telefone)" +
                "VALUES" + "(?,?,?,?,?)";
        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,employee.getCpf());
            ps.setInt(2,employee.getMatricula());
            ps.setString(3,employee.getNome());
            ps.setString(4,employee.getEmail());
            ps.setString(5,employee.getTelefone());

            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex){
            ex.printStackTrace();

        }
    }

    @Override
    public List<Employee> listAll() {
        String sql = "SELECT * FROM funcionario ORDER BY ID";
        List<Employee> employeeList = new ArrayList<>();

        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Employee employee = map(rs);
                employeeList.add(employee);
            }
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        String sql = "SELECT id, cpf, matricula, nome, email, telefone " +
                "FROM funcionario WHERE id = ?";
        Employee employee = null;

        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                employee = map(rs);
            }
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateName(int id, String nome) {
        String sql = "UPDATE funcionario SET nome = ? WHERE id = ?";
        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, id);

            ps.executeUpdate();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmail(int id, String email) {
        String sql = "UPDATE funcionario SET email = ? WHERE id = ?";
        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setInt(2, id);

            ps.executeUpdate();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhone(int id, String phone) {
        String sql = "UPDATE funcionario SET telefone = ? WHERE id = ?";
        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setInt(2, id);

            ps.executeUpdate();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";

        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
