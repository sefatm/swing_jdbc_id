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

public class DBConnection2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String userName =sc.next();
        
        System.out.print("Enter your Age: ");
        int userAge = sc.nextInt();
        
        System.out.print("Enter your Address: ");
        String userAddress = sc.next();
        
        String sql = "INSERT INTO employee1 (name, age, address) VALUES ('"+userName+"', '"+userAge+"', '"+userAddress+"')";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee_information";
            String user = "root";
            String password = "root";
            
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stmt = con.createStatement();
            
            int status = stmt.executeUpdate(sql);
            
            if (status > 0){
                System.out.println("inserted");
            } else {
                System.out.println("Fail");
            }
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Successfull");
        }
    }
}
