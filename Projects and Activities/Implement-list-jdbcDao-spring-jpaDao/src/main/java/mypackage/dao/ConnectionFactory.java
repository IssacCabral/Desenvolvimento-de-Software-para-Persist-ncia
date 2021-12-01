package mypackage.dao;

import mypackage.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(AppConfig.getConfig().getProperty("database.url"),
                AppConfig.getConfig().getProperty("database.user"),
                AppConfig.getConfig().getProperty("database.pass"));
    }
}
