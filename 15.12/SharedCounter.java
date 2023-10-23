import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter{
    private AtomicInteger counter = new AtomicInteger(0);
    private static Object s = new Object();
    

    public void incr() throws InterruptedException{
            Thread.sleep(100);
                synchronized(SharedCounter.this){
                    System.out.println(Thread.currentThread().getName()+": prende monitor");
                    counter.incrementAndGet();
                    System.out.println(Thread.currentThread().getName()+": notifica");
                    SharedCounter.this.notifyAll();
                    
                }
            
    }

    public void decr(){
       
        new Thread(new Runnable(){
            public void run(){
                synchronized(SharedCounter.this){
                    System.out.println(Thread.currentThread().getName()+": notifica");
                    counter.notifyAll();
                    System.out.println(Thread.currentThread().getName()+": prende monitor");
                    if(counter.get() != 0) counter.decrementAndGet();
                    System.out.println(Thread.currentThread().getName()+": notifica");
                    SharedCounter.this.notifyAll();
                }
            }
        }).start();
    
    }

    public void waitForValue(int n){
        
        new Thread(new Runnable(){
            public void run(){
                synchronized(SharedCounter.this){
                    System.out.println(Thread.currentThread().getName()+": prende monitor utente");
                    while(counter.get() != n){
                        try {
                            System.out.println(Thread.currentThread().getName()+": aspetta utente");
                            SharedCounter.this.wait();
                            System.out.println(Thread.currentThread().getName()+": si sveglia utente");
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            return;
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+": arrivato utente");
                }
            }
        }).start(); 
    
    }



}

class Main{
    public static void main(String arg[]){
        SharedCounter sh = new SharedCounter();
        Thread th = new Thread(new Runnable(){
            public void run(){
                try {
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                    sh.incr();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               
            }
        });
        sh.waitForValue(8);
        th.start();
        
        
    }
}