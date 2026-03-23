package org.example.calculatrice_soap;

import javax.xml.ws.Endpoint;

public class ServeurSOAP {
    public static void main(String[] args) {

        String url = "http://localhost:9000/calculatrice";

        System.out.println("Démarrage du serveur...");

        Endpoint.publish(url, new CalculatriceImp());

        System.out.println("Service lancé !");
        System.out.println("WSDL : " + url + "?wsdl");
    }
}