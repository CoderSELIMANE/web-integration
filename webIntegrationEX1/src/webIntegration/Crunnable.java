package webIntegration;

public class Crunnable implements Runnable {

    private String name;

    public Crunnable(String name){
        this.name = name;
    }

    public void run(){
        for(int c = 1; c <= 10; c++){
            System.out.println(name + " : " + c);
        }
    }
}