package com.swing.service;

import com.swing.model.User;
import com.swing.util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {

    Connection con;
    Statement stmt;

    public int addUser(User u) {
        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql = "INSERT INTO users (username, password) values ('" + u.getUsername() + "', '" + u.getPassword() + "')";
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            return 0;
        }
    }

    public int loginUser(User u) {
        try {
            System.out.println("enter");
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * from users where username = '" + u.getUsername() + "' ";
            ResultSet rs = stmt.executeQuery(sql);
            rs.absolute(1);
            if (u.getPassword().equals(rs.getString("password"))) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
