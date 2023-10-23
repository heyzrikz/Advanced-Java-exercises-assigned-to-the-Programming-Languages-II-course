import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

class AtLeast{
    public static void atLeast(int n, Runnable r) throws InterruptedException{
        AtomicBoolean terminato = new AtomicBoolean(false);
        BlockingQueue<Thread> queue = new ArrayBlockingQueue<>(n);
        final Object mutex = new Object();
        for(int i = 0 ; i < n ; i++){
            Thread th = new Thread(()->{
                r.run();
                synchronized(mutex){
                terminato.set(true);
                mutex.notify();
                }
            });
            queue.put(th);
            th.start();
        }

        synchronized(mutex){
            while(terminato.get() == false){
                mutex.wait();
            }
            for(int i = 0 ; i < n ; i++){
                queue.take().interrupt();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable(){
            public void run(){
                try {
                    Random rand = new Random();
                    Thread.sleep(rand.nextInt(10000)+1000);
                    System.out.println("Finito");
                } catch (InterruptedException e) {
                    System.out.println("interrotto");
                    return;
                }
                
            }
        };

        atLeast(5,r);
    }
}

