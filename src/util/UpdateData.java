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


public class UpdateData {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your id: ");
        int UserIdUpdate = input.nextInt();
        
        System.out.print("Enter your name: ");
        String UserNameUpdate = input.next();
        
        String sql = "UPDATE employee1 SET name = '"+UserNameUpdate+"' WHERE id = '"+UserIdUpdate+"'";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee_information";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stmt = con.createStatement();
            
            int status = stmt.executeUpdate(sql);
            
            if (status > 0){
                System.out.println("Update Successfull");
            } else {
                System.out.println("No record found");
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println("Upadate failed");
            System.out.println(e);
        }
    }
}
