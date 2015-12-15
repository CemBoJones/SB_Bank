/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.model;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import sse.sbbank.controller.dbaccess.DBAccess;

/**
 *
 * @author Marco
 */
@SessionScoped
@ManagedBean
public class User implements Serializable{
    
    private int kontonummer;
    private String vorname;
    private String nachname;
    private String username;
    private String password;
    private double kontostand;
    private boolean isAdmin;

    public User(){}
    
    public User(int kontonummer, String vorname, String nachname, String username, String password, double kontostand, boolean isAdmin) {
        this.kontonummer = kontonummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.username = username;
        this.password = password;
        this.kontostand = kontostand;
        this.isAdmin = isAdmin;
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
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
        return password;
    }

    public void setPasswort(String passwort) {
        this.password = passwort;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void transferToUser(int destiny, double amount, String tan){
        
        int sender = this.getKontonummer();

        DBAccess instance = new DBAccess();   
        if (instance.isUsable(tan)){
        instance.transfer(sender, destiny, amount);        
        this.setKontostand(instance.getUser(sender).getKontostand());
        }
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.kontonummer != other.kontonummer) {
            return false;
        }
        return true;
    }
    
}
