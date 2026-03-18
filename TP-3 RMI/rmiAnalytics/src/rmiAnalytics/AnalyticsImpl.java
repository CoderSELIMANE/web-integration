package rmiAnalytics;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class AnalyticsImpl extends UnicastRemoteObject implements IAnalytics {
    private List<Vente> ventes;
    protected AnalyticsImpl() throws RemoteException {
        super();
        ventes = new ArrayList<>();
    }

    @Override
    public void ajouterVente(Vente v) throws RemoteException {
        ventes.add(v);
    }
    @Override
    public double chiffreAffairesTotal() throws RemoteException {
        double total = 0;
        for (Vente v : ventes) {
            total += v.getAmount();
        }
        return total;
    }

    @Override
    public Map<String, Double> chiffreAffairesParRegion() throws RemoteException {
        Map<String, Double> map = new HashMap<>();

        for (Vente v : ventes) {
            map.put(v.getRegion(),
                    map.getOrDefault(v.getRegion(), 0.0) + v.getAmount());
        }

        return map;
    }
    @Override
    public String produitPlusVendu() throws RemoteException {

        Map<String, Integer> count = new HashMap<>();

        for (Vente v : ventes) {
            count.put(v.getProduct(),
                    count.getOrDefault(v.getProduct(), 0) + 1);
        }

        String maxProduct = null;
        int max = 0;

        for (String p : count.keySet()) {
            if (count.get(p) > max) {
                max = count.get(p);
                maxProduct = p;
            }
        }

        return maxProduct;
    }
    @Override
    public List<Vente> ventesSuperieures(double montant) throws RemoteException {

        List<Vente> res = new ArrayList<>();

        for (Vente v : ventes) {
            if (v.getAmount() > montant) {
                res.add(v);
            }
        }

        return res;
    }
    @Override
    public List<Vente> toutesLesVentes() throws RemoteException {
        return ventes;
    }
}