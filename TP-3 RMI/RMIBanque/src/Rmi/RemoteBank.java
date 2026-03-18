package Rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteBank extends UnicastRemoteObject implements IRemoteBank {

    private final List<Compte> cs;

    public RemoteBank() throws RemoteException {
        super();
        cs = new ArrayList<>();
    }
    @Override
    public int getSolde(int index) throws RemoteException {
        return cs.get(index).getSolde();
    }

    @Override
    public String getName(int index) throws RemoteException {
        return cs.get(index).getName();
    }
    @Override
    public void addCompte(Compte compte) throws RemoteException {
        cs.add(compte);
    }
    @Override
    public void bulkCompte(List<Compte> comptes) throws RemoteException {
        cs.addAll(comptes);
    }
    
    @Override
    public void retirer(int id, double montant) throws RemoteException {
        cs.get(id).retirer(montant);
    }
    
    @Override
    public void transferer(int id1, int id2, double montant) throws RemoteException {

        Compte c1 = cs.get(id1);
        Compte c2 = cs.get(id2);

        c1.retirer(montant);
        c2.deposer(montant);
    }
  
}