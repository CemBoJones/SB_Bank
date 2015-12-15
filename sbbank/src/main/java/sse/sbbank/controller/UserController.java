/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.controller;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sse.sbbank.controller.dbaccess.DBAccess;
import sse.sbbank.model.User;

/**
 *
 * @author Marco
 */
@ManagedBean(name = "userController", eager = true)
@SessionScoped
public class UserController implements Serializable{
    private DBAccess dbaccess = new DBAccess();
    private List <User> userlist = new LinkedList<User>();
    
    private String vorname;
    private String nachname;
    private String username;
    private String passwort;

    public UserController() {
        this.init();
    }
    
    
    public void init (){
        userlist = dbaccess.getUserListFromDB();
    }
    
    public void adNewUser() {
        User tempUser = new User(nextKontonummer(), vorname, nachname, username, passwort, 0.0, false);
        dbaccess.insertPersonenToDB(tempUser);
    }

    private int nextKontonummer(){
        int nextKontonummer = 0;
        for(User u : userlist){
            while(nextKontonummer <= u.getKontonummer()){
                nextKontonummer++;
            }
        }
        return nextKontonummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    
    
}
