package exercice1Proverbe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server4 {

    static List<String> proverbesF = new ArrayList<>();

    public Server4() {
        init();
    }

    public void init() {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\PC\\Desktop\\cindh\\fichier.txt"));

            String ligne;

            while ((ligne = br.readLine()) != null) {
                proverbesF.add(ligne);
            }

            br.close();
            ServerSocket ss = new ServerSocket(9080);
            System.out.println("Serveur en marche...");

            while (true) {

                System.out.println("En attente d'un client...");
                Socket s = ss.accept();
                
                System.out.println("Client connecté : " + s.getInetAddress());
                ClientThread thread = new ClientThread(s, proverbesF);

                thread.start();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        new Server4();

    }
}