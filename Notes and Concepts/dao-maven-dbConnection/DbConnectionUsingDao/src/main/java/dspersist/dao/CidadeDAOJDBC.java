package dspersist.dao;

import dspersist.model.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAOJDBC implements CidadeDao{
    @Override
    public List<Cidade> findAll() {
        List<Cidade> cidadeList = new ArrayList<>();
        try{
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("Conexão ok!");

            String sql = "SELECT * FROM cidade";
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1,2);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id_cid"));
                cidade.setNome(rs.getString("nome"));
                cidade.setUf(rs.getString("uf_cid"));
                cidadeList.add(cidade);
            }
        } catch (SQLException e){
            throw new DAOException(e);
        }
        return cidadeList;
    }
}
