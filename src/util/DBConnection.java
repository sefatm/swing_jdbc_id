/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your UserId: ");
        int User_id = sc.nextInt();
        
        System.out.print("Enter a password: ");
        int pass = sc.nextInt();
        
        String sql = "INSERT INTO emp1 (userid, password) VALUES ('"+User_id+"', '"+pass+"')";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/emp";
            String user = "root";
            String password = "root";
            
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stmt = con.createStatement();
            
            int status = stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
