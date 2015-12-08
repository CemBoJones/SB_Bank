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
public class Kontobewegung implements Serializable{
    private int sender;
    private int empfaenger;
    private double betrag;

    public Kontobewegung(int sender, int empfaenger, double betrag) {
        this.sender = sender;
        this.empfaenger = empfaenger;
        this.betrag = betrag;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getEmpfaenger() {
        return empfaenger;
    }

    public void setEmpfaenger(int empfaenger) {
        this.empfaenger = empfaenger;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }    
}
