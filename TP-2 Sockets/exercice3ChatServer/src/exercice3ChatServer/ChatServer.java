package exercice3ChatServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(9002);
            System.out.println("Serveur de chat démarré...");

            while (true) {

                Socket client = server.accept();

                System.out.println("Nouveau client connecté");

                ClientThread thread = new ClientThread(client);

                thread.start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
