/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.controller;

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
public class UserListBean {
    private DBAccess dBAccess;
    private List<User> userList;
    
    public UserListBean(){
        this.dBAccess=new DBAccess();
        this.userList=dBAccess.getUserListFromDB();
    }

    public List<User> getUserlist() {
        return userList;
    }

    public void setUserlist(List<User> userlist) {
        this.userList = userlist;
    }
    
}
