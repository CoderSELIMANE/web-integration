package exercice1Proverbe;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClientFichier {

	    public static void main(String[] args) {
	        try{
	            Socket s =new Socket("localhost",9080);
	            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

	            String proverbe = in.readLine();

	            System.out.println("Proverbe reçu : " + proverbe);

	            s.close();
	        }catch (Exception e){
	            throw  new RuntimeException(e);
	        }
	    }

}
