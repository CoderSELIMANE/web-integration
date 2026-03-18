package rmiAnalytics;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Map;

public class ClientRMI {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            IAnalytics service = (IAnalytics) registry.lookup("ANALYTICS");

            System.out.println("CA total : " + service.chiffreAffairesTotal());

            Map<String, Double> map = service.chiffreAffairesParRegion();
            System.out.println("CA par région : " + map);

            System.out.println("Produit le plus vendu : " + service.produitPlusVendu());

            List<Vente> list = service.ventesSuperieures(4000);
            System.out.println("Ventes > 4000 : " + list.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}