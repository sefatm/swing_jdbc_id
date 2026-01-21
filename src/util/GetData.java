/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class GetData {
    public static void main(String[] args) {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee_information";
            String user = "root";
            String password = "root";
            con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM employee";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getString(1) + ", fName: " + rs.getString(2) + ", lName: " + rs.getString(3) + ", Age: " + rs.getString(7) + ", Address: " + rs.getString(8));
            }
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
}
