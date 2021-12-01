package mypackage.dao;

import mypackage.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOJdbcSpring implements IEmployeeDAOSpring{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private Employee map(ResultSet rs) throws SQLException {
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
                "VALUES" + "(:cpf,:matricula,:nome,:email,:telefone)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("cpf", employee.getCpf())
                .addValue("matricula", employee.getMatricula())
                .addValue("nome", employee.getNome())
                .addValue("email", employee.getEmail())
                .addValue("telefone", employee.getTelefone());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public List<Employee> listAll() {
        String sql = "SELECT * FROM funcionario ORDER BY ID";
        return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void updateName(int id, String name) {

    }

    @Override
    public void updateEmail(int id, String email) {

    }

    @Override
    public void updatePhone(int id, String phone) {

    }

    @Override
    public void delete(int id) {

    }
}
