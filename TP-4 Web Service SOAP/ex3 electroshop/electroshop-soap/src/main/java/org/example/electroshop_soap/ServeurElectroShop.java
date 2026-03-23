package org.example.electroshop_soap;

import javax.xml.ws.Endpoint;

public class ServeurElectroShop {

    public static void main(String[] args) {

        String url = "http://localhost:9002/electroshop";

        System.out.println("Démarrage serveur ElectroShop...");

        Endpoint.publish(url, new ElectroShopService());

        System.out.println("Service disponible : " + url);
        System.out.println("WSDL : " + url + "?wsdl");
    }
}