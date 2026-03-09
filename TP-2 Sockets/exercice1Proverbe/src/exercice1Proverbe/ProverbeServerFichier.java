package exercice1Proverbe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProverbeServerFichier {
	static List<String> proverbesF = new ArrayList<>();
	
	public  ProverbeServerFichier() {
		
		init();
		
	}
	
	public void init() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC\\Desktop\\cindh\\fichier.txt"));

            String ligne;

            while ((ligne = br.readLine()) != null) {
                proverbesF.add(ligne);
            }

            br.close();
            
			ServerSocket ss = new ServerSocket(9000);
			System.out.println("le serveur en marche ");
			while(true) {
				Socket s = ss.accept(); 
                System.out.println("En attente d'une connexion...");
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                Random r = new Random();
                String proverbe = proverbesF.get(r.nextInt(proverbesF.size()));

                out.println(proverbe);
                
                s.close(); 
            }

        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
	}

    public static void main(String[] args) {
        new ProverbeServerFichier();
    }
}
