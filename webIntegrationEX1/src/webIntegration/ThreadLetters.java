package webIntegration;


public class ThreadLetters extends Thread {

    public ThreadLetters(String name){
        super(name);
    }

    @Override
    public void run(){
        for(char c = 'A'; c <= 'Z'; c++){
            System.out.println(getName() + " : " + c);
        }
    }
}