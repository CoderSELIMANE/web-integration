package Rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.List;
public class BankServeur {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            RemoteBank b = new RemoteBank();
            b.bulkCompte(List.of(
            		new Compte(1, "Ahmed", 2000),
                    new Compte(3, "Youssef", 3000),
                    new Compte(2, "Fatima", 1500)
            ));
            Naming.rebind("rmi://localhost:1099/mabank", b);

            System.out.println("Le serveur est maintenant en marche ....");
        } catch (Exception e) {
            e.printStackTrace();
            }
    }
}