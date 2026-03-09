package Exercice2WebServer;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServerWitheThreads {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(9999);
            System.out.println("Serveur Web démarré...");

            while (true) {

                Socket client = server.accept();

                System.out.println("Client connecté : " + client.getInetAddress());

                ConnexionsThread thread = new ConnexionsThread(client);

                thread.start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}