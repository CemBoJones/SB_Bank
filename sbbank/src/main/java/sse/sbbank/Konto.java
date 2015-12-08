/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank;

import java.io.Serializable;

/**
 *
 * @author Marco
 */
public class Konto implements Serializable{
    private int idKonto;
    private double kontostand;
    private int kontobewegungen;

    public Konto(int idKonto, double kontostand, int kontobewegungen) {
        this.idKonto = idKonto;
        this.kontostand = kontostand;
        this.kontobewegungen = kontobewegungen;
    }

    public int getIdKonto() {
        return idKonto;
    }

    public void setIdKonto(int idKonto) {
        this.idKonto = idKonto;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public int getKontobewegungen() {
        return kontobewegungen;
    }

    public void setKontobewegungen(int kontobewegungen) {
        this.kontobewegungen = kontobewegungen;
    }
}
