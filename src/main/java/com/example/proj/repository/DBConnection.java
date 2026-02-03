package com.example.proj.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "0000";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}