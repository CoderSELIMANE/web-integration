package org.example.SoapClientBanque;

import com.example.client.IBanque;
import com.example.client.BanqueServiceService;
import com.example.client.Compte;

public class Main {
    public static void main(String[] args) {

        BanqueServiceService service = new BanqueServiceService();
        IBanque port = service.getBanqueServicePort();

        double solde = port.consulterSolde(1);
        System.out.println("Solde : " + solde);

        port.deposer(1, 500);

        port.retirer(1, 200);

        System.out.println("Nouveau solde : " + port.consulterSolde(1));

        Compte c = port.getCompte(1);
        System.out.println("Solde final : " + c.getSolde());
    }
}