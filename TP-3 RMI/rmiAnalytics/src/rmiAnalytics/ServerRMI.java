package rmiAnalytics;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class ServerRMI {

    public static void main(String[] args) {

        try {

            AnalyticsImpl service = new AnalyticsImpl();

            // données test
            service.ajouterVente(new Vente(1, "PC", "Maroc", 5000, new Date()));
            service.ajouterVente(new Vente(2, "Phone", "France", 3000, new Date()));
            service.ajouterVente(new Vente(3, "PC", "Maroc", 7000, new Date()));

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("ANALYTICS", service);

            System.out.println("Serveur RMI démarré");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}