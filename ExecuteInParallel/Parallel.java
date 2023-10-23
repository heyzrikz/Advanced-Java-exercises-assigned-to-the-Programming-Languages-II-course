import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Parallel{
    public static void executeInParallel(Runnable[] r , int k) throws InterruptedException{
        List<Thread> inEsecuzione = new ArrayList<>();
        AtomicInteger kk = new AtomicInteger(k);
        Thread th = new Thread(new Runnable() {
         public void run(){
             while(! Thread.currentThread().isInterrupted()){
                 synchronized(inEsecuzione){
                     List<Thread> tmp = new ArrayList<>(inEsecuzione);
                 for(Thread t : tmp){
                     if(! t.isAlive()){
                         inEsecuzione.remove(t);
                        kk.incrementAndGet();
                        inEsecuzione.notifyAll();
                        try {
                            inEsecuzione.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            return;
                        }
                     }
                 }
                }
             }
         }   
        });
        th.start();
        int i = 0;
        while(i < r.length){
            while(i < r.length && kk.get() > 0){
                synchronized(inEsecuzione){
                    Thread t = new Thread(r[i]);
                    t.start();
                inEsecuzione.add(t);
                kk.decrementAndGet();
                i++;
                while(kk.get() == 0){
                    inEsecuzione.notifyAll();
                    inEsecuzione.wait();
                }
                }
            }
        }
        th.interrupt();
    }

}

class Main{
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
                        Parallel.executeInParallel(a,3);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                
            }
        };
    
        new Thread(r4).start();
    }
}