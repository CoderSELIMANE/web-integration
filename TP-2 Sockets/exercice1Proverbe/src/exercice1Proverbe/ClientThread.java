package exercice1Proverbe;
import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.io.PrintWriter;

public class ClientThread extends Thread{
	private Socket socket;
    private List<String> proverbes;
    
    public ClientThread(Socket socket, List<String> proverbes) {
        this.socket = socket;
        this.proverbes = proverbes;
    }

    public void run() {

        try {

            PrintWriter out = new PrintWriter( socket.getOutputStream(), true);
            Random r = new Random();
            String proverbe = proverbes.get(r.nextInt(proverbes.size()));

            out.println(proverbe);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
