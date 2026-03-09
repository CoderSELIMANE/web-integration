package exercice3ChatServer;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class ChatClientIHM extends JFrame {

    JTextArea zoneChat = new JTextArea();
    JTextField champMessage = new JTextField();
    PrintWriter out;

    public ChatClientIHM() {
        setTitle("Chat Client");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        zoneChat.setEditable(false);

        add(new JScrollPane(zoneChat), BorderLayout.CENTER);
        add(champMessage, BorderLayout.SOUTH);

        champMessage.addActionListener(e -> envoyerMessage());
        setVisible(true);

        connecter();
    }

    public void connecter() {

        try {
            Socket socket = new Socket("localhost", 9002);
            BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String pseudo = JOptionPane.showInputDialog("Votre pseudo :");

            new Thread(() -> {
                try {
                    String msg;

                    while ((msg = in.readLine()) != null) {
                        zoneChat.append(msg + "\n");
                    }
                } catch (Exception e) {
                }
            }).start();

            champMessage.addActionListener(e -> {

                String message = champMessage.getText();
                out.println(pseudo + " : " + message);
                champMessage.setText("");

            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void envoyerMessage() {

        String message = champMessage.getText();
        out.println(message);
        champMessage.setText("");
    }

    public static void main(String[] args) {

        new ChatClientIHM();

    }
}
