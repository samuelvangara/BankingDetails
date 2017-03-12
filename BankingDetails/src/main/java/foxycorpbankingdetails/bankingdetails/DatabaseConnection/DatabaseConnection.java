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
    
    static boolean LoginCheckBoolean = true, PasswordCheckBoolean= true;
    static int RegistrationDetailsInsertionCheck,PasswordChangeUpdateCheck;
    static Connection connection=null;
    static PreparedStatement preparedStatement =null;
    static ResultSet resultSet = null;
    public static final String LOGIN_CHECK = "select exists(select username,password from usercredentials where username=? and password=?)";
    public static final String REGISTRATION_INSERTION = "insert into usercredentials (firstname,lastname,emailid,username,password,phonenumber,hint) values(?,?,?,?,?,?,?)";
    public static final String PASSWORD_CHANGE_CHECK="select exists(select username,hint from usercredentials where username=? and hint=?)";
    public static final String PASSWORD_CHANGE_UPDATE="UPDATE usercredentials SET password = ? WHERE username = ? and hint = ?";
    
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
      
      public int RegisterationDetailsInsertion(String Firstname,String Lastname,String Emailid,String Username,String Password,long Phonenumber,String Hint)
      {
           getConnection();
        try {
            preparedStatement = connection.prepareStatement(REGISTRATION_INSERTION);
            preparedStatement.setString(1, Firstname);
            preparedStatement.setString(2, Lastname);
            preparedStatement.setString(3, Emailid);
            preparedStatement.setString(4, Username);
            preparedStatement.setString(5, Password);
            preparedStatement.setLong(6, Phonenumber);
            preparedStatement.setString(7, Hint);
            RegistrationDetailsInsertionCheck=preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException ex) {
           System.out.println("SQL Exception in the RegisterationDetailsInsertion method"+ex);
           
        }
          return RegistrationDetailsInsertionCheck;
      }
      
      
      public boolean ChangePasswordCheck(String Username, String Hint)
      {
          getConnection();
        try {
            preparedStatement = connection.prepareStatement(PASSWORD_CHANGE_CHECK);
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Hint);
            resultSet=preparedStatement.executeQuery();
           while(resultSet.next())
           {
           PasswordCheckBoolean = resultSet.getBoolean(1);
           }
            resultSet.close();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the ChangePasswordCheck method"+ex);
        }
          return PasswordCheckBoolean;
      }
      
       public int ChangePasswordUpdate(String Username,String Hint,String Password)
      {
           getConnection();
        try {
            preparedStatement = connection.prepareStatement(PASSWORD_CHANGE_UPDATE);
            preparedStatement.setString(1, Password);
            preparedStatement.setString(2, Username); 
            preparedStatement.setString(3, Hint);
            PasswordChangeUpdateCheck=preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException ex) {
           System.out.println("SQL Exception in the RegisterationDetailsInsertion method"+ex);
           
        }
          return PasswordChangeUpdateCheck;
      }
    
}
