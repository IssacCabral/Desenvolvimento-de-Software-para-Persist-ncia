package dspersist.dao;

import dspersist.config.AppConfig;
import dspersist.ui.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(AppConfig.getConfig().getProperty("database.url"),
               AppConfig.getConfig().getProperty("database.user"),
               AppConfig.getConfig().getProperty("database.pass"));
    }
//    public static Connection getConnection() throws SQLException{
//        String url = "jdbc:postgresql://localhost:5432/Frete"; //Caminho do banco
//        String user = "postgres"; //User default do postgres
//        String password = "postgres"; //Pass do banco
//        return DriverManager.getConnection(url,user,password);
//    }
}
