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
public class Admin implements Serializable{
    
    private int idAdmin;
    private String adminname;
    private String adminpasswort;

    public Admin(){};
    
    public Admin(int idAdmin, String adminname, String adminpasswort) {
        this.idAdmin = idAdmin;
        this.adminname = adminname;
        this.adminpasswort = adminpasswort;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpasswort() {
        return adminpasswort;
    }

    public void setAdminpasswort(String adminpasswort) {
        this.adminpasswort = adminpasswort;
    }
    
    
}
