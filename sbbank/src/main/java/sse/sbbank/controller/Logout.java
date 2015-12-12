/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sse.sbbank.model.User;

/**
 *
 * @author Marco
 */
@ManagedBean
@SessionScoped
public class Logout {

    private User current;

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/sbbank/index.xhtml?faces-redirect=true";
    }
    
}
