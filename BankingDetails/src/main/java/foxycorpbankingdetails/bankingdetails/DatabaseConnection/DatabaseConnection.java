/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.DatabaseConnection;

import foxycorpbankingdetails.bankingdetails.POJO.UserInformation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Foxy
 */
public class DatabaseConnection {
    
    public static boolean LoginCheckBoolean = true, PasswordCheckBoolean= true, databaseCheck=true;
    public static int RegistrationDetailsInsertionCheck,PasswordChangeUpdateCheck,BalanceDetailsInsertionCheck;
    public static long RetrievedPhoneNumber;
    public static String RetrievedBalance=null,RetrievedId=null,RetrievedRewards=null,RetrievedFirstName=null,RetrievedLastName=null,RetrievedEmailID=null,RetrievedUsername=null;
    static Connection connection=null;
    static Connection connectionDBCreate=null;
    static PreparedStatement preparedStatement =null;
    static ResultSet resultSet = null;
    public static final String CHECK_DATABASE = "select exists(SELECT * from pg_database WHERE datname='bankingdetails')"; 
    public static final String CREATE_DATABASE = "create database bankingdetails"; 
    public static final String CREATE_SEQUENCE="CREATE SEQUENCE IF NOT EXISTS UserCredSequence CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 20";
    public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS usercredentials (id integer NOT NULL DEFAULT nextval('UserCredSequence'),firstname name NOT NULL,lastname name NOT NULL,emailid character varying(40) NOT NULL,username name NOT NULL,password character varying(15) NOT NULL,phonenumber numeric(10) NOT NULL,hint character varying(30) NOT NULL)";
    public static final String CREATE_SEQUENCE_BALANCE="CREATE SEQUENCE IF NOT EXISTS UserCredBalance CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 20";
    public static final String CREATE_TABLE_BALANCE="CREATE TABLE IF NOT EXISTS userbalance (id integer NOT NULL DEFAULT nextval('UserCredBalance'),username name NOT NULL,balance numeric(10) NOT NULL,rewards numeric(10) NOT NULL)";
    public static final String LOGIN_CHECK = "select exists(select username,password from usercredentials where username=? and password=?)";
    public static final String REGISTRATION_INSERTION = "insert into usercredentials (firstname,lastname,emailid,username,password,phonenumber,hint) values(?,?,?,?,?,?,?)";
    public static final String BALANCE_AND_REWARDS_INSERTION = "insert into userbalance (username,balance,rewards) values(?,5000,30)";         
    public static final String PASSWORD_CHANGE_CHECK="select exists(select username,hint from usercredentials where username=? and hint=?)";
    public static final String PASSWORD_CHANGE_UPDATE="UPDATE usercredentials SET password = ? WHERE username = ? and hint = ?";
    public static final String RETRIEVE_BALANCE="select balance,id,rewards from userbalance where username=?";
    public static final String RETRIEVE_USERINFORMATION="select * from usercredentials where username=?";
    
    public void getConnectionBeforeDBCreation()
    {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connectionDBCreate = DriverManager.getConnection("jdbc:postgresql://2601:5cc:c901:f4f9:b5ff:a6af:83e6:8fb0:5432/", "postgres","Nitinz!424");
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
                connection = DriverManager.getConnection("jdbc:postgresql://2601:5cc:c901:f4f9:b5ff:a6af:83e6:8fb0:5432/bankingdetails", "postgres","Nitinz!424");
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
        
      public void createBalanceSequence()
      {
          getConnectionAfterDBCreation();
        try {
            preparedStatement = connection.prepareStatement(CREATE_SEQUENCE_BALANCE);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the createBalanceSequence method"+ex);
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
      
      public void createBalanceTable()
      {
          getConnectionAfterDBCreation();
   
        try {
            preparedStatement = connection.prepareStatement(CREATE_TABLE_BALANCE);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
             System.out.println("SQL Exception in the createBalanceTable method"+ex);
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
      
      
      public int BalanceRewardsDetails(String Username)
      {
         getConnectionAfterDBCreation();
        try {
            preparedStatement = connection.prepareStatement(BALANCE_AND_REWARDS_INSERTION);
            preparedStatement.setString(1, Username);
            BalanceDetailsInsertionCheck=preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the BalanceRewardsDetails method"+ex);
        }
         
         return BalanceDetailsInsertionCheck;
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
       
       public String RetrieveBalance(String Username)
       {
           getConnectionAfterDBCreation();
        try {        
            preparedStatement = connection.prepareStatement(RETRIEVE_BALANCE);
            preparedStatement.setString(1, Username);
           resultSet=preparedStatement.executeQuery();
           while(resultSet.next())
           {
           RetrievedBalance = resultSet.getString(1);
           RetrievedId = resultSet.getString(2);
           RetrievedRewards=resultSet.getString(3);
           System.out.println(RetrievedBalance);
           System.out.println(RetrievedId);
           System.out.println(RetrievedRewards);
           
           }
            resultSet.close();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the RetrieveBalance method"+ex);
        }
           return RetrievedBalance;
       }
       
       public ArrayList<UserInformation> RegisterationDetailsRetrevial(String Username)
       {
         ArrayList<UserInformation> UserInformation = new ArrayList<>();
         UserInformation ufo = new UserInformation();
         getConnectionAfterDBCreation();
        try {
            preparedStatement = connection.prepareStatement(RETRIEVE_USERINFORMATION);
            preparedStatement.setString(1, Username);
           resultSet=preparedStatement.executeQuery();
           while(resultSet.next())
           {
           RetrievedFirstName=resultSet.getString(2);
           RetrievedLastName=resultSet.getString(3);
           RetrievedEmailID=resultSet.getString(4);
           RetrievedUsername=resultSet.getString(5);
           RetrievedPhoneNumber=resultSet.getLong(7);
           System.out.println(RetrievedFirstName);
           System.out.println(RetrievedLastName);
           System.out.println(RetrievedEmailID);
           System.out.println(RetrievedPhoneNumber);
           ufo.setFirstname(RetrievedFirstName);
           ufo.setLastname(RetrievedLastName);
           ufo.setEmailid(RetrievedEmailID);
           ufo.setUsername(RetrievedUsername);
           ufo.setPhonenumber(RetrievedPhoneNumber);
           }
            UserInformation.add(ufo);
            resultSet.close();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException ex) {
            System.out.println("SQL Exception in the RegisterationDetailsRetrevial method"+ex);
        }
           
         return UserInformation;
       }
    
}
