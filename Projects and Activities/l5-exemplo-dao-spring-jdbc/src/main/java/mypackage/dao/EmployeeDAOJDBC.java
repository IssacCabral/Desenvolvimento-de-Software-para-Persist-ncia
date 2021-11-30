package mypackage.dao;

import mypackage.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOJDBC implements IEmployeeDAO{
    @Autowired
    //private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO funcionario (cpf,matricula,nome,email,telefone)" +
                "VALUES" + "(:cpf,:matricula,:nome,:email,:telefone)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("cpf", employee.getCpf())
                .addValue("matricula", employee.getMatricula())
                .addValue("nome", employee.getNome())
                .addValue("email", employee.getEmail())
                .addValue("telefone", employee.getTelefone());

        jdbcTemplate.update(sql, params);
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

    @Override
    public List<Employee> listAll() {
        String sql = "SELECT * FROM funcionario ORDER BY ID";
        return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
    }

    @Override
    public Employee findById(int id){
        String sql = "SELECT id, cpf, matricula, nome, email, telefone " +
                     "FROM funcionario WHERE id = :id_";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id_", id);
        return jdbcTemplate.queryForObject(sql, namedParameters, (rs, numRow) -> map(rs));
    }

    @Override
    public void update(Integer id,String cpf,Integer matricula,String nome,String email,String telefone){
        String sql = "UPDATE funcionario SET cpf = :cpf, matricula = :matricula, nome = :nome, " +
                     "email = :email, telefone = :telefone WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("cpf", cpf)
                .addValue("matricula", matricula)
                .addValue("nome", nome)
                .addValue("email", email)
                .addValue("telefone", telefone)
                .addValue("id", id);

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM funcionario WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        jdbcTemplate.update(sql, params);

    }
}
