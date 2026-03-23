package org.example.banque_soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IBanque {

    @WebMethod
    double consulterSolde(int id);

    @WebMethod
    void retirer(int id, double montant);

    @WebMethod
    void deposer(int id, double montant);

    @WebMethod
    Compte getCompte(int id);
}
