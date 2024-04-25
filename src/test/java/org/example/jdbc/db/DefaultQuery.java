package org.example.jdbc.db;

import org.example.jdbc.utils.DatabaseConnector;

import java.sql.Connection;

/**
 * Base class for actions in db tables.
 */
public abstract class DefaultQuery {
    protected final static Connection connection = DatabaseConnector.getConnection();

}
