package Rmi;

import java.rmi.Naming;

public class ClientBankPopulaire {
    public static void main(String[] args) throws Exception {

        IRemoteBank bp = (IRemoteBank) Naming.lookup("rmi://127.0.0.1:1099/mabank");

        System.out.println("Le nom de Propriataire 0 est : " + bp.getName(0));

        System.out.println("Le solde de Propriataire 1 est : " + bp.getSolde(1));
        bp.retirer(1, 500);
        System.out.println("Solde après retrait : " + bp.getSolde(1));
        bp.transferer(2,1,300);
        System.out.println("Solde client 1 après transfert : " + bp.getSolde(1));
    }
}