import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Exec{
    public static void executeInParallel(Runnable[] r , int num) throws InterruptedException{
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(Arrays.asList(r));
        BlockingQueue<Thread> thread_queue = new ArrayBlockingQueue<>(num);
        final Object mutex = new Object();
        for(int i = 0 ; i < num ; i++){
            Thread th = new Thread(()->{
                while(! Thread.currentThread().isInterrupted()){
                    try {
                        queue.take().run();
                    } catch (InterruptedException e) {
                        return;
                    }
                    synchronized(mutex){
                        mutex.notifyAll();
                    }
                }
            });
            th.start();
            thread_queue.put(th);
        }
        
        synchronized(mutex){
        while(! queue.isEmpty()){
            mutex.wait();
        }
        for(int i = 0 ; i< num ; i++){
            thread_queue.take().interrupt();
        }
        }
    }

    public static void main(String arg[]){
        Runnable r1  = new Runnable(){
            public void run(){
                try {
                    System.out.println("inizio r1");
                    Thread.sleep(2000);
                    System.out.println("fine r1");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
    
        Runnable r2  = new Runnable(){
            public void run(){
                try {
                    System.out.println("inizio r2");
                    Thread.sleep(4000);
                    System.out.println("fine r2");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
    
        Runnable r3  = new Runnable(){
            public void run(){
                try {
                    System.out.println("inizio r3");
                    Thread.sleep(1000);
                    System.out.println("fine r3");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
    
        Runnable[] a = new Runnable[]{r1,r2,r3,r1,r2};
    
        Runnable r4  = new Runnable(){
            public void run(){
                    System.out.println(Thread.currentThread().getName()+" executeInParallel");
                    try {
                        executeInParallel(a,3);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                
            }
        };
    
        new Thread(r4).start();
    }
}