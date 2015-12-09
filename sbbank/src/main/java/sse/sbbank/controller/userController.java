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
@ManagedBean
@SessionScoped
public class UserController implements Serializable{
    DBAccess dbaccess = new DBAccess();
    List <User> userlist = new LinkedList<User>();
    
    public void init (){
        userlist = dbaccess.getUserListFromDB();
    }
    
    public void adNewUser(int kontonummer, String vorname, String nachname, String username, String passwort) {
        User tempUser = new User(kontonummer, vorname, nachname, username, passwort, 0, false);
    }
}
