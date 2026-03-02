package webIntegration;


public class ThreadNumbers extends Thread {

    public ThreadNumbers(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int c = 1; c <= 10; c++){
            System.out.println(getName() + " : " + c);
        }
    }
}