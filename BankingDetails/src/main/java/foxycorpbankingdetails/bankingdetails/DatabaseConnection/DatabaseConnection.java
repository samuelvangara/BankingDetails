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

/**
 *
 * @author Foxy
 */
public class DatabaseConnection {
    
    static boolean LoginCheckBoolean = true;
    static Connection connection=null;
    static PreparedStatement preparedStatement =null;
    static ResultSet resultSet = null;
    public static final String LOGIN_CHECK = "select exists(select username,password from usercredentials where username=? and password=?)";
    public static final String UPDATE_TABLE = "Insert into userinfo values(?,?,?,?,?)";

    
    public void getConnection()
    {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/BankingData", "postgres","Nitinz!424");
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
      
      
      public boolean LoginCheck(String username, String password)
      {
           getConnection();
        try {
            preparedStatement = connection.prepareStatement(LOGIN_CHECK);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet=preparedStatement.executeQuery();
           while(resultSet.next())
           {
           LoginCheckBoolean = resultSet.getBoolean(1);
           }
            resultSet.close();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException ex) {
           System.out.println("SQL Exception in the LoginCheck method");
           
        }
          return LoginCheckBoolean;
      }
    
}
