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
    
    static boolean LoginCheckBoolean = true, PasswordCheckBoolean= true, databaseCheck=true;
    static int RegistrationDetailsInsertionCheck,PasswordChangeUpdateCheck;
    static Connection connection=null;
    static Connection connectionDBCreate=null;
    static PreparedStatement preparedStatement =null;
    static ResultSet resultSet = null;
    public static final String CHECK_DATABASE = "select exists(SELECT * from pg_database WHERE datname='bankingdetials')"; 
    public static final String CREATE_DATABASE = "create database bankingdetials"; 
    public static final String CREATE_SEQUENCE="CREATE SEQUENCE IF NOT EXISTS UserCredSequence CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 20";
    public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS usercredentials (id integer NOT NULL DEFAULT nextval('UserCredSequence'),firstname name NOT NULL,lastname name NOT NULL,emailid character varying(20) NOT NULL,username name NOT NULL,password character varying(15) NOT NULL,phonenumber numeric(10) NOT NULL,hint character varying(30) NOT NULL)";
    public static final String LOGIN_CHECK = "select exists(select username,password from usercredentials where username=? and password=?)";
    public static final String REGISTRATION_INSERTION = "insert into usercredentials (firstname,lastname,emailid,username,password,phonenumber,hint) values(?,?,?,?,?,?,?)";
    public static final String PASSWORD_CHANGE_CHECK="select exists(select username,hint from usercredentials where username=? and hint=?)";
    public static final String PASSWORD_CHANGE_UPDATE="UPDATE usercredentials SET password = ? WHERE username = ? and hint = ?";
    
    public void getConnectionBeforeDBCreation()
    {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connectionDBCreate = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/", "postgres","Nitinz!424");
            } catch (SQLException ex) {
               System.out.println("SQL Exception in the getConnectionBeforeDBCreation method"+ex);
            }
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception in the getConnectionBeforeDBCreation method"+ex);
        }
        
    }
    
    
     public void getConnectionAfterDBCreation()
    {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/bankingdetials", "postgres","Nitinz!424");
            } catch (SQLException ex) {
               System.out.println("SQL Exception in the getConnectionAfterDBCreation method"+ex);
            }
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception in the getConnectionAfterDBCreation method"+ex);
        }
        
    }
    
      public void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the closeConnection method"+ex);
        }
    }
      
       public boolean checkDatabase()
      {
          getConnectionBeforeDBCreation();
        try {
           preparedStatement = connectionDBCreate.prepareStatement(CHECK_DATABASE);
           resultSet=preparedStatement.executeQuery();
           while(resultSet.next())
           {
           databaseCheck = resultSet.getBoolean(1);
           }
            resultSet.close();
            preparedStatement.close();
            connectionDBCreate.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the checkDatabase method"+ex);
        }
         return databaseCheck;
      }
      
      public void createDatabase()
      {
          getConnectionBeforeDBCreation();
        try {
            preparedStatement = connectionDBCreate.prepareStatement(CREATE_DATABASE);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connectionDBCreate.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the createDatabase method"+ex);
        }
         
      }
        public void createSequence()
      {
         getConnectionAfterDBCreation();
        try {
            preparedStatement = connection.prepareStatement(CREATE_SEQUENCE);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
          System.out.println("SQL Exception in the createSequence method"+ex);
        }
          
          closeConnection();
      }
      
      public void createTable()
      {
         getConnectionAfterDBCreation();
        try {
            preparedStatement = connection.prepareStatement(CREATE_TABLE);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
           System.out.println("SQL Exception in the createTable method"+ex);
        }
          
          closeConnection();
      }
      
      
      public boolean LoginCheck(String username, String password)
      {
          getConnectionAfterDBCreation();
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
           System.out.println("SQL Exception in the LoginCheck method"+ex);
           
        }
          return LoginCheckBoolean;
      }
      
      public int RegisterationDetailsInsertion(String Firstname,String Lastname,String Emailid,String Username,String Password,long Phonenumber,String Hint)
      {
           getConnectionAfterDBCreation();
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
          getConnectionAfterDBCreation();
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
           getConnectionAfterDBCreation();
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
