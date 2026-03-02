package webIntegration;

public class Lrunnable implements Runnable{
	
    private String name;

    public Lrunnable(String name){
        this.name = name;
    }

    public void run(){
        for(char c = 'A' ; c <= 'Z'; c++) {
            System.out.println(name + " : " + c);
        }
    }
    
}
