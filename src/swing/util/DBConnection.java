package com.swing.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    private static final String DB_URL = "jdbc:mysql://localhost:3306/swing_login"; 
    private static final String DB_USERNAME = "root"; 
    private static final String DB_PASSWORD = "root"; 
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER_CLASS);
            Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            return con;
        } catch (Exception e) {
            return null;
        }
    }
}
