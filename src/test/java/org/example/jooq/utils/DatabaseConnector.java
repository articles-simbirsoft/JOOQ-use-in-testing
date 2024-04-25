package org.example.jooq.utils;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.codegen.GenerationTool;
import org.jooq.impl.DSL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for create db connection.
 */
public final class DatabaseConnector {
    private DatabaseConnector() {

    }
    private static Connection connection = getConnection();
    private static DSLContext context;

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

    public static DSLContext getContext() {
        if (context == null) {
            context = DSL.using(connection, SQLDialect.MYSQL);
            try {
                GenerationTool.generate(
                        Files.readString(
                                Path.of("src\\test\\resources\\jooq-config.xml")
                        )
                );
            } catch (Exception ignored) {
                new RuntimeException();
            }
        }
        return context;
    }
}
