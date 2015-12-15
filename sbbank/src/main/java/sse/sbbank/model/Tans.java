/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import sse.sbbank.controller.dbaccess.DBAccess;

/**
 *
 * @author hella
 */
public class Tans {
    
    private int idTans;
    private BigInteger tan;
    private boolean isUsable;
    private String groupname;



    public void setTan(BigInteger tan) {
        this.tan = tan;
    }

    public void setIsUsable(boolean isUsable) {
        this.isUsable = isUsable;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    
    
    

    public BigInteger getTan() {
        return tan;
    }

    public boolean isIsUsable() {
        return isUsable;
    }

    public String getGroupname() {
        return groupname;
    }
    
    
    
}
