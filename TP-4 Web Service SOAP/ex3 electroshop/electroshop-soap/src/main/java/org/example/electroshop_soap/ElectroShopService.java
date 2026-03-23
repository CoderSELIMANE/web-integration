package org.example.electroshop_soap;

import javax.jws.WebService;
import java.util.*;
import java.util.stream.Collectors;

@WebService(endpointInterface = "org.example.electroshop_soap.IElectroShop")
public class ElectroShopService implements IElectroShop {

    private List<Vente> ventes = new ArrayList<>();

    @Override
    public boolean ajouterVente(String magasin, String produit,
                                int quantite, double prixUnitaire, Date dateVente) {

        ventes.add(new Vente(magasin, produit, quantite, prixUnitaire, dateVente));
        return true;
    }

    @Override
    public double consulterCA(String magasin, Date debut, Date fin) {

        return ventes.stream()
                .filter(v -> v.getMagasin().equals(magasin))
                .filter(v -> v.getDateVente().after(debut) && v.getDateVente().before(fin))
                .mapToDouble(v -> v.getQuantite() * v.getPrixUnitaire())
                .sum();
    }

    @Override
    public List<String> topProduits(String magasin, Date debut, Date fin, int n) {

        Map<String, Integer> map = new HashMap<>();

        for (Vente v : ventes) {
            if (v.getMagasin().equals(magasin)
                    && v.getDateVente().after(debut)
                    && v.getDateVente().before(fin)) {

                map.put(v.getProduit(),
                        map.getOrDefault(v.getProduit(), 0) + v.getQuantite());
            }
        }

        return map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public double predireVentes(String magasin, Date jour) {

        return ventes.stream()
                .filter(v -> v.getMagasin().equals(magasin))
                .sorted((a, b) -> b.getDateVente().compareTo(a.getDateVente()))
                .limit(5)
                .mapToDouble(v -> v.getQuantite() * v.getPrixUnitaire())
                .average()
                .orElse(0);
    }
}