/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.model;

import java.io.Serializable;

/**
 *
 * @author Marco
 */
public class User implements Serializable{
    
    private int kontonummer;
    private String vorname;
    private String nachname;
    private String username;
    private String passwort;
    private double kontostand;
    private boolean isAdmin;

    public User(){}
    
    public User(int kontonummer, String vorname, String nachname, String username, String passwort, double kontostand, boolean isAdmin) {
        this.kontonummer = kontonummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.username = username;
        this.passwort = passwort;
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
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
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
    
}
