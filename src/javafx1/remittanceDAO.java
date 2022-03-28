/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Windows.10
 */
public class remittanceDAO {

    
     protected ArrayList<model> data;
    
    public remittanceDAO()
    {
        this.data=new ArrayList<>();
    }
    public ArrayList<model> getData()
    {
        return this.data;
    }
    
//    public boolean retrieve()
//    {
//        this.data.clear();
//        //Build the SQL query
//        String query="SELECT * FROM customer;" ;
//        //Execute the query via the BasicDB methods
//        ResultSet result=remittanceDB.retrieve(query);
//        
//       try{
//           if(!result.next())
//               return false;
//          do{
//               //Copy the returned result set into the array list
//                model temp=new model();
//               //Form the BookModel object for each returned row
//               temp.setID(result.getInt(2));
//               temp.setSenderName(result.getString(2)); //The first index of the columns is 1 not 0
//               temp.setSenderPhone(result.getInt(3));
//               
//               //Add the record to the list
//               this.data.add(temp);
//           } while(result.next());
//           return true;
//       }
//       catch(SQLException e){ 
//       }
//       return false;
//    }
    
    
    
    public void add2(model model)
    {
        //Clear the previous data
        this.data.clear();
        //Form the query
        String query="insert into send_money (senderName,senderPhone,frombrunch,tobrunch, recieverPhone,amount,notice) values( '"+
                 model.getSenderName()+"','"+model.getSenderPhone()+"','"+model.getFrombrunch()+"','"+model.getTobrunch()+"','"+model.getRecieverPhone()+"','"+model.getAmount()+"','"+model.getNotice()+"'  )";
        //Execute the query
        int rows=remittanceDB.manipulate(query);
        //Add the new book record to the list
        this.data.add(model);
    }
    
    public void re (model model)
    {
        //Clear the previous data
        this.data.clear();
        //Form the query
        String query="insert into recieve (recieverName, recieverPhone,notice) values( '"+
                model.getRecieverName()+"','"+model.getRecieverPhone()+"','"+model.getNotice()+"'  )";
        //Execute the query
        int rows=remittanceDB.manipulate(query);
        //Add the new book record to the list
        this.data.add(model);
    }
   
    
    public int retrievenotice(int  notice)
    {
        //Clear the previous data
        this.data.clear();
        //Build the SQL query
        String query="select amount from send_money where notice = '"+notice+"' ";
        //Execute the query via the BasicDB methods
        ResultSet result=remittanceDB.retrieve(query);
        model temp=new model(); 
       try{
           
           
               //Copy the returned result set into the array list
               
            while(result.next())
            {
                
                temp.setAmount(result.getInt(1)); 
               this.data.add(temp);
            
           return temp.getAmount();
          }
          }  
       catch(SQLException e){ 
       }
       return temp.getAmount();
    }
    
    
    
//     public boolean retrieve(int ID)
//    {
//        this.data.clear();
//        //Build the SQL query
//        String query="SELECT * FROM send_money where senderID='"+ID+"' " ;
//        //Execute the query via the BasicDB methods
//        ResultSet result=remittanceDB.retrieve(query);
//        
//       try{
//           if(!result.next())
//               return false;
//          do{
//               //Copy the returned result set into the array list
//                model temp=new model();
//               //Form the BookModel object for each returned row
//               temp.setID(result.getInt(1));
//               temp.setSenderName(result.getString(2)); //The first index of the columns is 1 not 0
//               temp.setSenderPhone(result.getInt(3));
//               temp.setRecieverName(result.getString(4)); //The first index of the columns is 1 not 0
//               temp.setRecieverPhone(result.getInt(5));
//               temp.setFrombrunch(result.getString(6));
//               temp.setTobrunch(result.getString(7));
//               temp.setAmount(result.getInt(8));
//               temp.setNotice(result.getInt(9));
//               //Add the record to the list
//               this.data.add(temp);
//           } 
//          
//          while(result.next());
//          {
//           return true;
//           
//          }
//           
//       }
//       catch(SQLException e){ 
//       }
//       return false;
//    }
//    
//   public boolean getAllData()
//    {
//        //Clear the previous data
//        this.data.clear();
//        //Form the Select* query
//        String query="Select * from send_money";
//        //Execute the query
//        ResultSet result=remittanceDB.retrieve(query);
//        //Copy the returned result set into the array list
//        
//        try{
//            while(result.next())
//            {
//                model temp=new model();
//               //Form the BookModel object for each returned row
//               temp.setID(result.getInt(1));
//               temp.setSenderName(result.getString(2)); //The first index of the columns is 1 not 0
//               temp.setSenderPhone(result.getInt(3));
//               temp.setRecieverName(result.getString(4)); //The first index of the columns is 1 not 0
//               temp.setRecieverPhone(result.getInt(5));
//               temp.setFrombrunch(result.getString(6));
//               temp.setTobrunch(result.getString(7));
//               temp.setAmount(result.getInt(8));
//               temp.setNotice(result.getInt(9));
//               
//               
//               //Add the record to the list
//               this.data.add(temp);
//               return true;
//            }
//        }
//        catch(SQLException e){
//        }
//        return false;
//        
// 
//    }
//    
   
   public boolean retrieve(int ID)
    {
        this.data.clear();
        //Build the SQL query
        String query="SELECT * FROM send_money where senderID='"+ID+"' " ;
        //Execute the query via the BasicDB methods
        ResultSet result=remittanceDB.retrieve(query);
        
       try{
           if(!result.next())
               return false;
          do{
               //Copy the returned result set into the array list
                model temp=new model();
               //Form the BookModel object for each returned row
               temp.setSenderName(result.getString(2)); 
               temp.setSenderPhone(result.getInt(3));
               temp.setFrombrunch(result.getString(4)); 
               temp.setTobrunch(result.getString(5));
               temp.setRecieverPhone(result.getInt(6));
               
               temp.setAmount(result.getInt(7));
               temp.setNotice(result.getInt(8));
               
               //Add the record to the list
               this.data.add(temp);
           } 
          
          while(result.next());
          {
           return true;
           
          }
           
       }
       catch(SQLException e){ 
       }
       return false;
    }
   
   
   
   public boolean retrieve2(int senderPhone)
    {
        this.data.clear();
        //Build the SQL query
        String query="SELECT * FROM send_money where senderPhone='"+senderPhone+"' " ;
        //Execute the query via the BasicDB methods
        ResultSet result=remittanceDB.retrieve(query);
        
       try{
           if(!result.next())
               return false;
          do{
               //Copy the returned result set into the array list
                model temp=new model();
               //Form the BookModel object for each returned row
               temp.setSenderName(result.getString(2)); 
               temp.setSenderPhone(result.getInt(3));
               temp.setFrombrunch(result.getString(4)); 
               temp.setTobrunch(result.getString(5));
               temp.setRecieverPhone(result.getInt(6));
               
               temp.setAmount(result.getInt(7));
               temp.setNotice(result.getInt(8));
               
               //Add the record to the list
               this.data.add(temp);
           } 
          
          while(result.next());
          {
           return true;
           
          }
           
       }
       catch(SQLException e){ 
       }
       return false;
    }
   
   
   
   
   public void update(int ID,int recieverPhone)
    {
        //Form the query 
        String query="update send_money set recieverPhone = "+recieverPhone+" where senderID= '"+ID+"'";
        //Execute the query 
        int rows=remittanceDB.manipulate(query);
    }
    
   
    
}
