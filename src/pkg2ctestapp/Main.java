
package pkg2ctestapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:2Ctestapp.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

   
    public static void main(String[] args) {
      Scanner sc =new Scanner (System.in);
        System.out.println("Enter student Id:");
        int id =sc.nextInt();
        System.out.println("First name:");
        String fn = sc.next();
        System.out.println("Last name:");
        String ln = sc.next();
        System.out.println("Email:");
        String eml = sc.next();
        System.out.println("Status:");
        String stats = sc.next();

        String sql = "INSERT INTO Students (S_ID, S_Firstname, S_Lastname, S_Email, S_Status) VALUES (?, ?, ?, ?, ?)";
        
        
        try{
            Connection con =connectDB();
            PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1,id);
                pst.setString(2, fn);
                pst.setString(3, ln);
                pst.setString(4, eml);
                pst.setString(5, stats);
                pst.executeUpdate();
                System.out.println("Inserted Sucessfully!");
              
        } catch (SQLException ex){
                System.out.println("Connection Error:"+ex.getMessage());
                }
        }
        
        
    }
    