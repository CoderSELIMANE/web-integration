package Rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRemoteBank extends Remote {

    int getSolde(int index) throws RemoteException;

    String getName(int index) throws RemoteException;
    void addCompte(Compte compte) throws RemoteException;

    void bulkCompte(List<Compte> comptes) throws RemoteException;
    
    void retirer(int id, double montant) throws RemoteException;

    void transferer(int id1, int id2, double montant) throws RemoteException;
}