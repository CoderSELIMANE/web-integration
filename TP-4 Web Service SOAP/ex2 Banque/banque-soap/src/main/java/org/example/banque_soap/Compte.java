package org.example.banque_soap;

import java.util.Date;

public class Compte {

    private int id;
    private double solde;

    private transient Date dateCreation;

    public Compte(int id, double solde) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = new Date();
    }

    public int getId() { return id; }

    public double getSolde() { return solde; }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}