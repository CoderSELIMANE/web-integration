package org.example.banque_soap;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "org.example.banque_soap.IBanque")
public class BanqueService implements IBanque {

    private Map<Integer, Compte> comptes = new HashMap<>();
    
    public BanqueService() {
        comptes.put(1, new Compte(1, 1000));
        comptes.put(2, new Compte(2, 2000));
    }
    @Override
    public double consulterSolde(int id) {
        return comptes.get(id).getSolde();
    }
    @Override
    public void retirer(int id, double montant) {
        Compte c = comptes.get(id);
        c.setSolde(c.getSolde() - montant);
    }
    @Override
    public void deposer(int id, double montant) {
        Compte c = comptes.get(id);
        c.setSolde(c.getSolde() + montant);
    }
    @Override
    public Compte getCompte(int id) {
        return comptes.get(id);
    }
}