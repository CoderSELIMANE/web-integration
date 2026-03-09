package exercice1Proverbe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
	static List<String> proverbes = Arrays.asList(
            "rira rien qui rira le dernier",
            "L'habit ne fait pas le moine",
            "Tout vient à point à qui sait attendre"
    );
	
	public Server() {
		
		init();
		
	}
	
	public void init() {
	
        try {
			ServerSocket ss = new ServerSocket(9099);
			System.out.println("le serveur en marche ");
			while(true) {
				Socket s = ss.accept(); 
                System.out.println("En attente d'une connexion...");


                PrintWriter out = new PrintWriter(s.getOutputStream(), true);

                Random r = new Random();
                String proverbe = proverbes.get(r.nextInt(proverbes.size()));

                out.println(proverbe);
                
                s.close(); 
            }

        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
	}

    public static void main(String[] args) {
        new Server();
    }

}
