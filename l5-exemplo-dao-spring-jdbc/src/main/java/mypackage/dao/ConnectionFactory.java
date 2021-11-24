package mypackage.dao;

import mypackage.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(AppConfig.getconfig().getProperty("spring.datasource.url"),
                AppConfig.getconfig().getProperty("spring.datasource.username"),
                AppConfig.getconfig().getProperty("spring.datasource.password"));
    }
}
