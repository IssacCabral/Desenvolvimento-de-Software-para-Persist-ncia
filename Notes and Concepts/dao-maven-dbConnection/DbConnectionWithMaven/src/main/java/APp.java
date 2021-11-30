import java.sql.*;

public class APp {

    public static void main(String[] args){
        try{
            Connection conn = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM cidade";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id_cid");
                String nome = rs.getString("nome");
                System.out.println(id + " - " + nome);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
