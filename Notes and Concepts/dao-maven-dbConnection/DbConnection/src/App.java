import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/Funcionarios"; //Caminho do banco
        String user = "postgres"; //User default do postgres
        String password = "postgres"; //Pass do banco

        try{
            //Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection ok!");

//            String sql = "INSERT INTO empregado(matricula,nome,salario)" +
//                         "VALUES ('1', 'Issac', 3500)";
//
//            Statement statement = conn.createStatement();
//            statement.execute(sql);

            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
