import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection()throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Frete"; //Caminho do banco
        String user = "postgres"; //User default do postgres
        String password = "postgres"; //Pass do banco
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
