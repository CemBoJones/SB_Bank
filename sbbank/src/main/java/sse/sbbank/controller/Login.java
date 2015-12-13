package sse.sbbank.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sse.sbbank.controller.dbaccess.DBAccess;
import sse.sbbank.model.User;

/**
 *
 * @author Marco
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

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
            HttpSession session = SessionBean.getSession();
            if (user.isIsAdmin()) {
                session.setAttribute("username", userName);
                return "Admin success";
            } else {
                session.setAttribute("username", userName);
                return "success";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passoword",
                            "Please enter correct username and Password"));
            return "fail";
        }
    }
    
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "/sbbank/index.xhtml?faces-redirect=true";
    }
}
