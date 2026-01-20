/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBConnection1 {
    public static void main(String[] args) {
        
        Properties prop = new Properties();
        
        try {
            InputStream dbFile = new FileInputStream("E:\\New Folder\\swing_jdbc_id\\src\\db.properties");
            prop.load(dbFile);
            
            String url = prop.getProperty("dburl");
            String user = prop.getProperty("dbusername");
            String password = prop.getProperty("dbpassword");
            System.out.println(url + " " + user + " " + password);
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Test successful");
            
            Statement stmt = con.createStatement();
            
            int status = stmt.executeUpdate(url);
            
            if (status > 0){
                System.out.println("inserted");
            } else {
                System.out.println("failed");
            } 
        } catch (SQLException se){
            System.out.println(se.getMessage());
        } catch (IOException ie){
            System.out.println(ie.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
