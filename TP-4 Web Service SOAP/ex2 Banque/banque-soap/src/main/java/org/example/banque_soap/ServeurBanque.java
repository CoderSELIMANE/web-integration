package org.example.banque_soap;

import javax.xml.ws.Endpoint;

public class ServeurBanque {
    public static void main(String[] args) {

        String url = "http://localhost:9001/banque";

        System.out.println("Démarrage serveur Banque...");

        Endpoint.publish(url, new BanqueService());

        System.out.println("Service disponible sur : " + url);
        System.out.println("WSDL : " + url + "?wsdl");
    }
}