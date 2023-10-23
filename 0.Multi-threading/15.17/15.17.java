import java.util.HashSet;
import java.util.Set;

class SharedTotal{
    private volatile double total = 0;
    private final Object mutex = new Object();
    private Set<Thread> threads = new HashSet<>();
    private volatile boolean terminato = false;

    public SharedTotal(long millis){
        new Thread(()->{
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(mutex){
                terminato = true;
                mutex.notifyAll();

            }
        }).start();
    }

    public double sendValAndReceiveTot(double val) throws InterruptedException{
        synchronized(mutex){
            if(threads.contains(Thread.currentThread())) throw new RuntimeException("Invocato più volte dallo stesso thread");
            else threads.add(Thread.currentThread());
            total = total + val;
            while(terminato == false){
                mutex.wait();
            }
            return total;
        }
    }

}

class Main{
    public static void main(String arg[]){
        SharedTotal tot = new SharedTotal(1000);
        new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println(tot.sendValAndReceiveTot(5.0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println(tot.sendValAndReceiveTot(10.0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}