package exercice3ChatServer;

import java.io.*;
import java.net.*;

public class ClientThread extends Thread {

    private Socket socket;
    private PrintWriter out;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

	public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader( socket.getInputStream()));
            out = new PrintWriter( socket.getOutputStream(), true);
            ChatServer.clients.add(out);

            String msg;

            while ((msg = in.readLine()) != null) {
            	
                for (PrintWriter client : ChatServer.clients) {
                    client.println(msg);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}