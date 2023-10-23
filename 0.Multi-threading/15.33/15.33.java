import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

class AtLaest{
    public static void atLeastOne(int n , Runnable r) throws InterruptedException{
        List<Thread> threads = new ArrayList<>();
        final Object mutex = new Object();
        AtomicBoolean terminato = new AtomicBoolean(false);

        for(int i = 0 ; i < n ; i++){
            Thread th = new Thread(()->{
                r.run();
                synchronized(mutex){
                    terminato.set(true);
                    mutex.notify();
                }
            });
            threads.add(th);
            th.start();
        }

        synchronized(mutex){
            while(terminato.get() == false){
                mutex.wait();
            }

            for(int i = 0 ; i < n ; i++){
                threads.get(i).interrupt();
            }
            
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable(){
            public void run(){
                try {
                    Random rand = new Random();
                    Thread.sleep(rand.nextInt(10000)+1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    System.out.println(Thread.currentThread().getName()+" è stato interrotto");
                }
                
            }
        };

        atLeastOne(5,r);
    }
}