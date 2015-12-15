/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sse.sbbank.controller.dbaccess.DBAccess;

/**
 *
 * @author Marco
 */
@ManagedBean(name = "transferBean", eager = true)
@SessionScoped
public class TransferBean {
    private DBAccess dBAccess;
    private int sender; 
    private int destiny;
    private double amount;
    
    public TransferBean(){
        dBAccess = new DBAccess();
    }
    
    public void doTransfere(int kontonummerUser){
        dBAccess.transfer(kontonummerUser, destiny, amount);
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getDestiny() {
        return destiny;
    }

    public void setDestiny(int destiny) {
        this.destiny = destiny;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
