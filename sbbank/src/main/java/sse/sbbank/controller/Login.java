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
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import sse.sbbank.controller.dbaccess.DBAccess;
import sse.sbbank.model.User;

/**
 *
 * @author Marco
 */
@ManagedBean(name = "login")
@SessionScoped
public class Login implements Serializable {

    private String userName;
    private String password;
    private User loggedUser = new User();
    private DBAccess dBAccess = new DBAccess();
    private int destiny;
    private double amount;

    public int getDestiny() {
        return destiny;
    }

    public void setDestiny(int destiny) {
        this.destiny = destiny;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

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

    public void doTransfere(int kontonummerUser) {
        dBAccess.transfer(kontonummerUser, destiny, amount);
        double newKontostand = this.loggedUser.getKontostand()-amount;
        this.loggedUser.setKontostand(newKontostand);
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
            loggedUser = userList.get(foundUser);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (loggedUser.isIsAdmin()) {
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
//        String username = "test";
//        String pw = "123";
//        
//        loggedUser.setUsername(username);
//        loggedUser.setKontostand(100.0);
//        loggedUser.setKontonummer(1);
//        if (username.equals(userName) && pw.equals(password)) {
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            session.setAttribute("username", username);
//            return "Admin success";
//        } else {
//            return "fail";
//        }
    }

    public String logout() throws ServletException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

        return "logout";
    }
}
