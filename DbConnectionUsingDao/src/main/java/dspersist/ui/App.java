package dspersist.ui;

import dspersist.dao.ConnectionFactory;
import dspersist.model.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
        try{
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("Conexão ok!");

            String sql = "SELECT * FROM cidade";
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1,2);
            ResultSet rs = ps.executeQuery();
            List<Cidade> cidadeList = new ArrayList<>();
            while(rs.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id_cid"));
                cidade.setNome(rs.getString("nome"));
                cidade.setUf(rs.getString("uf_cid"));
                System.out.println(cidade);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
