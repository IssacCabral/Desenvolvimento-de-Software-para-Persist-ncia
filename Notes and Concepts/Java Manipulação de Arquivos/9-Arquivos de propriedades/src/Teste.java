import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Teste {
    public static void main(String[] args) throws SQLException {
        Properties config = new Properties();
        config.setProperty("database.login", "scott");
        config.setProperty("database.password", "tiger");
        config.setProperty("database.url", "jdbc:jdbc:mysql localhost /t\n" +
                "este");

        // muitas linhas depois

        String login = config.getProperty("database.login");
        String password = config.getProperty("database.password");
        String url = config.getProperty("database.url");
        DriverManager.getConnection(url, login, password);
    }
}
