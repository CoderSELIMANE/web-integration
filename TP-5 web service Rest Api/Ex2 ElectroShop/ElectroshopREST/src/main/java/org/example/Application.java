package org.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Application {

    public static final String BASE_URI =
            "http://localhost:9094/api/";

    public static HttpServer startServer() {

        final ResourceConfig config =
                new ResourceConfig()
                        .packages("org.example.resource");

        return GrizzlyHttpServerFactory
                .createHttpServer(URI.create(BASE_URI), config);
    }

    public static void main(String[] args) {

        final HttpServer server = startServer();

        System.out.println("========================================");
        System.out.println(" ElectroShop REST démarré !");
        System.out.println(" Base URI : " + BASE_URI);
        System.out.println("========================================");

        System.out.println("\nEndpoints disponibles :");

        System.out.println("GET    " + BASE_URI + "sales");
        System.out.println("GET    " + BASE_URI + "sales/{id}");
        System.out.println("POST   " + BASE_URI + "sales");
        System.out.println("PUT    " + BASE_URI + "sales/{id}");
        System.out.println("DELETE " + BASE_URI + "sales/{id}");
        System.out.println("GET    " + BASE_URI + "sales/count");

        System.out.println("\nAppuyez Entrée pour arrêter...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        server.shutdownNow();
    }
}