package com.scc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Make sure this points to your SQLite database file path if it's placed somewhere specific,
    // or just "jdbc:sqlite:ticket_system.db" if it's in your main project folder.
    private static final String URL = "jdbc:sqlite:scenario.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}