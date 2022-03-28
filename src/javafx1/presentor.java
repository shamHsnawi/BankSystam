/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx1;


import java.sql.Array;
import javafx.stage.Window;

import java.util.ArrayList;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
/**
 *
 * @author Windows.10
 */
public class presentor {
    protected view view;
    protected controller controller;
    protected remittanceDAO remittanceDAO;

    
    
    public presentor(view view) {
        this.view=view;
        this.remittanceDAO=remittanceDAO;
        addHandlers();
    }
    
    public presentor(view view,remittanceDAO remittanceDAO) {
        this.view=view;
        this.remittanceDAO=remittanceDAO;
        addHandlers();
    }

    private void addHandlers() {
        
        this.view.clear.setOnAction(action->{
            this.view.trecieverPhone.clear();
            this.view.tamount.clear();
            this.view.tfull_name.clear();
            this.view.tphone.clear();
        });
        
        this.view.clear2.setOnAction(action->{
            this.view.tfull_name.clear();
            this.view.tphone.clear();
            this.view.t1.clear();
        });
        
        this.view.b2.setOnAction(action->{
            int notice;
            int amount=Integer.parseInt(this.view.tamount.getText());
            int recieverPhone=Integer.parseInt(this.view.trecieverPhone.getText());
            String frombrunch=this.view.choice.getValue();
            String tobrunch=this.view.choiceto.getValue();
            String senderName=this.view.tfull_name.getText();
            int senderPhone=Integer.parseInt(this.view.tphone.getText());
            int min = 1000;
            int max = 9999;
            notice = (int)Math.floor(Math.random()*(max-min+1)+min);
            
            
            String number=String.valueOf(recieverPhone);
            char []phoneNumbers=new char[number.length()];
            for(int i=0;i<number.length();i++)
            {
                phoneNumbers[i]=number.charAt(i);
            }
            int count=0;
            
            for(int j=0;j<phoneNumbers.length;j++)
            {
                
                count++;
            }
            
            if(count>10)
            {
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("wrong Phone number 1");
                alert.show();
            }
            else if(frombrunch.contains(tobrunch))
            {
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("you have mistakes in brunchs chose");
                alert.show();
            }
            
            else if(amount>1000000)
            {
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("you can not transform more than one million");
                alert.show();
            }
            else{
            this.remittanceDAO.add2(new model(senderName,senderPhone,frombrunch,tobrunch,recieverPhone,amount,notice));
            }
            this.view.trecieverPhone.clear();
            this.view.tamount.clear();
            this.view.tfull_name.clear();
            this.view.tphone.clear();
            
            
        });
        
        
        this.view.b3.setOnAction(action->{
            
            String recieverName=this.view.tfull_name2.getText();
            int recieverPhone=Integer.parseInt(this.view.tphone2.getText());
            int notice2=Integer.parseInt(this.view.t1.getText());
            String getamount=String.valueOf(this.remittanceDAO.retrievenotice(notice2));
            
            
            
            this.remittanceDAO.re (new model(recieverName,recieverPhone,notice2));
            view.ta.setText(getamount);
            this.view.t1.clear();
            this.view.tfull_name.clear();
            this.view.tphone.clear();
            
        });
        
        this.view.returnData.setOnAction(e->{
            int phone=Integer.parseInt(this.view.tenterSenderPhone.getText());
            if(this.remittanceDAO.retrieve2(phone)){
                //Fill the table view with the returned result
                this.view.table.setItems(FXCollections.observableArrayList(this.remittanceDAO.getData()));
            }
            else{
                this.view.tsenderID.clear();
                
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No Results were Found");
                alert.show();
            }
        });
        
        
        
        
        this.view.click.setOnAction(e->{
            int ID=Integer.parseInt(this.view.tsenderID.getText());
            if(this.remittanceDAO.retrieve(ID)){
                //Fill the table view with the returned result
                this.view.table.setItems(FXCollections.observableArrayList(this.remittanceDAO.getData()));
            }
            else{
                this.view.tsenderID.clear();
                this.view.table.setItems(FXCollections.observableArrayList(this.remittanceDAO.getData()));
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No Results were Found");
                alert.show();
            }
        });
//        
//        
//        this.view.click.setOnAction(e->{
//            this.remittanceDAO.getAllData();
//                //Fill the table view with the returned result
//                this.view.table.setItems(FXCollections.observableArrayList(this.remittanceDAO.getData()));
//            
//        });
        
        


        this.view.update.setOnAction(action->{
            int ID=Integer.parseInt(this.view.tenterCustomerID.getText());
            int phone=Integer.parseInt(this.view.tenterCustomerPhone.getText());
            this.remittanceDAO.update(ID,phone);
            if(this.remittanceDAO.retrieve(ID)){
                //Fill the table view with the returned result
                this.view.table.setItems(FXCollections.observableArrayList(this.remittanceDAO.getData()));
            }
            this.view.tenterCustomerID.clear();
            this.view.tenterCustomerPhone.clear();
        });

        
        
        
        
    }
    
    
}
