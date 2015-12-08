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
    
    private int idUser;
    private String vorname;
    private String nachname;
    private String username;
    private String passwort;
    private int kontonummer;

    public User(){}
    
    public User(int idUser, String vorname, String nachname, String username, String passwort, int kontonummer) {
        this.idUser = idUser;
        this.vorname = vorname;
        this.nachname = nachname;
        this.username = username;
        this.passwort = passwort;
        this.kontonummer = kontonummer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }
}
