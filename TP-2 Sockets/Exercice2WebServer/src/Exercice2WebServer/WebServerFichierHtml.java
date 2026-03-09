package Exercice2WebServer;

import java.io.*;
import java.net.*;

public class WebServerFichierHtml {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9000);
            System.out.println("Serveur Web démarré...");
            
            while (true) {
                Socket client = server.accept();
                BufferedReader br = new BufferedReader(new FileReader("C:/Users/PC/Desktop/index.html"));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println("HTTP/1.0 200 OK");
                out.println();

                String ligne;
                while ((ligne = br.readLine()) != null) {
                    out.println(ligne);
                }
                br.close();
                client.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
