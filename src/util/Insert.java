/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author Sefat Mahmud
 */
public class Insert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a Name: ");
        String userName = input.next();
        
        System.out.println("Enter a Sunject: ");
        String userSubject = input.next();
        
        System.out.println("Enter a Address: ");
        String userAddress = input.next();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/emplopyee2";
            String user = "root";
            String password = "root";
            
            Connection con = DriverManager.getConnection(url, user, password);
            
            String sql = "INSERT INTO employee_2(name, subject, address) VALUES (?, ?, ?)";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(2, userName);
        } catch (Exception e) {
        }
    }
}
