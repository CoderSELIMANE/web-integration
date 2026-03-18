package rmiAnalytics;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface IAnalytics extends Remote {

    void ajouterVente(Vente v) throws RemoteException;

    double chiffreAffairesTotal() throws RemoteException;

    Map<String, Double> chiffreAffairesParRegion() throws RemoteException;

    String produitPlusVendu() throws RemoteException;

    List<Vente> ventesSuperieures(double montant) throws RemoteException;

    List<Vente> toutesLesVentes() throws RemoteException;
}