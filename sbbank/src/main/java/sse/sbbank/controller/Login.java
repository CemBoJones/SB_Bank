package sse.sbbank.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import sse.sbbank.controller.dbaccess.DBAccess;
import sse.sbbank.model.User;

/**
 *
 * @author Marco
 */
@Named
@ManagedBean(name = "login")
@SessionScoped
public class Login {

    private String userName;
    private String password;

    private DBAccess userAccess = new DBAccess();
    private List<User> userList = userAccess.getUserListFromDB();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        userList = userAccess.getUserListFromDB();
        boolean found = false;
        int foundUser = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (userName.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPasswort())) {
                found = true;
                foundUser = i;
            }

        }
        if (found) {
            User user = userList.get(foundUser);
            if (user.isIsAdmin()) {
                return "Admin success";
            }else return "success";
        } else {
            return "fail";
        }
    }

//    public void validatePassword(ComponentSystemEvent event) {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        UIComponent comp = event.getComponent();
//        
//        UIInput pass1 = (UIInput) comp.findComponent("passwordText");
//        String password1 = "";
//        if(pass1.getLocalValue() != null){
//            password1 = pass1.getLocalValue().toString();
//        }
//        
//        UIInput pass2 = (UIInput) comp.findComponent("passwordText2");
//        String password2 = "";
//        if(pass2.getLocalValue() != null){
//            password2 = pass2.getLocalValue().toString();
//        }
//        
//        String passwordID = pass2.getClientId();
//        
//        if(password1.isEmpty() || password2.isEmpty()){
//            return;
//        }
//        
//        if(!password1.endsWith(password2)){
//            FacesMessage fm = new FacesMessage("Die passwörter stimmen nicht überein");
//            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
//            fc.addMessage(passwordID, fm);
//            fc.renderResponse();
//        }
}
