package org.example.jdbc.utils;

import org.example.jdbc.utils.ParametersProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for create db connection.
 */
public final class DatabaseConnector {
    private DatabaseConnector() {

    }
    private static Connection connection;
    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                String dbDriverClass = ParametersProvider
                        .getProperty("jdbc.driver");
                String dbUrl = ParametersProvider
                        .getProperty("jdbc.url");
                String dbUsername = ParametersProvider
                        .getProperty("jdbc.username");
                String dbPassword = ParametersProvider
                        .getProperty("jdbc.password");

                Class.forName(dbDriverClass);
                connection = DriverManager.getConnection(dbUrl, dbUsername,
                        dbPassword);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException("Connection error", e);
            }
        }
        return connection;
    }
}
