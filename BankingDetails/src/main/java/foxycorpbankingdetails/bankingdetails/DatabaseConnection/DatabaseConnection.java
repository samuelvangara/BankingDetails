/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Foxy
 */
public class DatabaseConnection {
    
    static Connection connection=null;
    static PreparedStatement preparedStatement =null;
    static ResultSet resultSet = null;
    
    public void getConnection()
    {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/UserData", "postgres","Nitinz!424");
            } catch (SQLException ex) {
               System.out.println("SQL Exception in the getConnection method");
            }
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception in the getConnection method");
        }
        
    }
    
      public void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the closeConnection method");
        }
    }
      
      
    
}
