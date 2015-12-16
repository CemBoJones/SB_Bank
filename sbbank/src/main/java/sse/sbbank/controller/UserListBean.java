/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sse.sbbank.controller.dbaccess.DBAccess;
import sse.sbbank.model.User;

/**
 *
 * @author Marco
 */
@ManagedBean
@SessionScoped
public class UserListBean {

    private DBAccess dbAccess;
    private List<User> userList;
    private int kontonummer;
    private String vorname;
    private String nachname;
    private String username;
    private String passwort;

    public UserListBean() {
        this.dbAccess = new DBAccess();
        this.userList = dbAccess.getUserListFromDB();
    }

    public List<User> getUserlist() {
        return userList;
    }

    public void setUserlist(List<User> userlist) {
        this.userList = userlist;
    }

    public void deleteUser() {
        dbAccess.deletePersonFromDB(kontonummer);
        dbAccess = new DBAccess();
        this.userList = dbAccess.getUserListFromDB();
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }
    
    public void addNewUser() {
        User tempUser = new User(nextKontonummer(), vorname, nachname, username, passwort, 0.0, false);
        dbAccess.insertPersonenToDB(tempUser);
        dbAccess = new DBAccess();
        this.userList = dbAccess.getUserListFromDB();
    }

    private int nextKontonummer(){
        int nextKontonummer = 0;
        for(User u : userList){
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
