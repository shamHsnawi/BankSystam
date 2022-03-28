/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx1;

import java.util.LinkedList;

/**
 *
 * @author Windows.10
 */
public class model {
    protected int ID;
    protected String senderName;
    protected int senderPhone;
    protected String recieverName;
    protected int recieverPhone;
    protected int amount;
    protected int notice;
    protected String frombrunch;
    protected String tobrunch; 
    
//    public model(String full_name, int phone_number){
//        this.full_name=full_name;
//        this.phone_number=phone_number;
//    }

    model() {
    }

    public model(String senderName,int senderPhone,String frombrunch,String tobrunch, int recieverPhone, int amount,int notice){
        this.senderName=senderName;
        this.senderPhone=senderPhone;
        this.frombrunch=frombrunch;
        this.tobrunch=tobrunch;
        this.recieverPhone=recieverPhone;
        this.amount=amount;
        this.notice=notice;
    }

    public model(String recieverName, int recieverPhone,int notice){
        this.recieverName=recieverName;
        this.recieverPhone=recieverPhone;
        this.notice=notice;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setSenderPhone(int senderPhone) {
        this.senderPhone = senderPhone;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName = recieverName;
    }

    public void setRecieverPhone(int recieverPhone) {
        this.recieverPhone = recieverPhone;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setNotice(int notice) {
        this.notice = notice;
    }

    public void setFrombrunch(String frombrunch) {
        this.frombrunch = frombrunch;
    }

    public void setTobrunch(String tobrunch) {
        this.tobrunch = tobrunch;
    }

    public int getID() {
        return ID;
    }

    public String getSenderName() {
        return senderName;
    }

    public int getSenderPhone() {
        return senderPhone;
    }

    public String getRecieverName() {
        return recieverName;
    }

    public int getRecieverPhone() {
        return recieverPhone;
    }

    public int getAmount() {
        return amount;
    }

    public int getNotice() {
        return notice;
    }

    public String getFrombrunch() {
        return frombrunch;
    }

    public String getTobrunch() {
        return tobrunch;
    }
    
    
   
    
}
