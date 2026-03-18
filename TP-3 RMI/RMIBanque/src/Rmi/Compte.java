package Rmi;

import java.io.Serializable; 

public class Compte implements Serializable {
	
	private int id;
    private int solde;
    private String Name;
    
    public Compte(int id, String Name, int solde) {
        this.id = id;
        this.Name = Name;
        this.solde = solde;
        
    }

	public int getId() {
        return id;
    }
    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name; 
    }
    
    public void deposer(double m) {
        solde += m;
    }

    public void retirer(double m) {
        solde -= m;
    }
}