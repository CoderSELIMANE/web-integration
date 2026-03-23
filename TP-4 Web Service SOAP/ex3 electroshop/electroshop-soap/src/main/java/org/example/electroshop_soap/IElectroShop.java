package org.example.electroshop_soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface IElectroShop {

    @WebMethod
    boolean ajouterVente(String magasin, String produit,int quantite, double prixUnitaire, Date dateVente);

    @WebMethod
    double consulterCA(String magasin, Date dateDebut, Date dateFin);

    @WebMethod
    List<String> topProduits(String magasin, Date dateDebut, Date dateFin, int n);

    @WebMethod
    double predireVentes(String magasin, Date jour);
}
