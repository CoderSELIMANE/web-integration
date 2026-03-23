package org.example.electroshop_soap;

import java.util.Date;

public class Vente {

    private String magasin;
    private String produit;
    private int quantite;
    private double prixUnitaire;
    private Date dateVente;

    public Vente() {}

    public Vente(String magasin, String produit, int quantite,
                 double prixUnitaire, Date dateVente) {
        this.magasin = magasin;
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.dateVente = dateVente;
    }

    public String getMagasin() { return magasin; }
    public String getProduit() { return produit; }
    public int getQuantite() { return quantite; }
    public double getPrixUnitaire() { return prixUnitaire; }
    public Date getDateVente() { return dateVente; }
}