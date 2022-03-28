/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx1;


import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Windows.10
 */
public class remittanceDB {
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    
    private static final String DATABASE_URL="jdbc:mysql://localhost/remittancedata";
    
    private static final String DATABASE_USER="root";
    
    private static final String DATABASE_PASSWORD="";
    
    private static Connection connection=null; 
    
    private static void connect()
    {
        //Create the connection with mysql server 
        try{
            //Register the driver
            Class.forName(DRIVER);
            //Initilaise the connection
            connection=DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private static void disconnect()
    {
        try{
            connection.close();
        }
        catch(SQLException ex)
        {
            
        }
    }
    
    public static ResultSet retrieve(String query)
    {
        //First connect to the database server
        connect();
        try{
            //Create a statement in order to execute the query
            Statement statement=connection.createStatement();
            //Execute the query
            CachedRowSetImpl result=new CachedRowSetImpl();
            //Save the result as a cached result 
            result.populate(statement.executeQuery(query));
            //Close the connection
            disconnect();
            return result;
        }
        catch(SQLException ex)
        {
            
        }
        disconnect();
        return null;
    }
    
    public static int manipulate(String query)
    {
        //First connect to the database server
        connect();
        try{
            //Create the Statement object
            Statement statement=connection.createStatement();
            //Execute the DML query
            int rowsAffected=statement.executeUpdate(query);
            return rowsAffected;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
}
