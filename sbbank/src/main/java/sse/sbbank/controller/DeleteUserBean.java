package sse.sbbank.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sse.sbbank.controller.dbaccess.DBAccess;

/**
 *
 * @author Marco
 */
@ManagedBean(name = "deleteUserBean", eager = true)
@SessionScoped
public class DeleteUserBean {
    private int Kontonummer;
    DBAccess dBAccess;
    
    public DeleteUserBean() {
        this.dBAccess = new DBAccess();
    }
    
    public void deleteUser(){
        dBAccess.deletePersonFromDB(Kontonummer);
    }

    public int getKontonummer() {
        return Kontonummer;
    }

    public void setKontonummer(int Kontonummer) {
        this.Kontonummer = Kontonummer;
    }
    
   
}
