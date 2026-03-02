package webIntegration;

public class Main {

    public Main(){
        conJobs();
        conJobs2();
    }

    public void conJobs(){
        Thread t1 = new ThreadLetters("t1");
        Thread t2 = new ThreadNumbers("t2");

        t2.start();
        try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        t1.start();   
        
    }
    
    public void conJobs2() {
    	Thread t1 = new Thread(new Crunnable("TRunnable-1"));
        Thread t2 = new Thread(new Lrunnable("TRunnable-2"));

        t1.start();
        try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        t2.start();
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
