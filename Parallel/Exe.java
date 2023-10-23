import java.util.ArrayList;
import java.util.List;

public class Exe{
    private static List<Thread> inEsecuzione = new ArrayList<>(); 
    private static int i = 0;
    private final static Object lock = new Object();
    public static void executeInParallel(ArrayList<Runnable> r , int k){
        synchronized(lock){
            new Thread(new Runnable(){
                public void run(){
                    synchronized(lock){
                        System.out.println(Thread.currentThread().getName()+" prendo monitor");
                    while(i < r.size()){
                    aggiornoList();
                    }
                }
                }
            }).start();
        while(i < r.size()){
            System.out.println(Thread.currentThread().getName()+" creo thread");
            Thread th = new Thread(r.get(i));
            th.start();
            inEsecuzione.add(th);
            i++;
        
        while((inEsecuzione.size() >= k)){
            System.out.println(Thread.currentThread().getName()+" entro in attesa");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    } 
}
}

private static void aggiornoList(){
    
    //System.out.println(Thread.currentThread().getName()+" aggiorno list");
    List<Thread> local = new ArrayList<>(inEsecuzione);
        for(Thread th : local){
        if(!th.isAlive()){
            System.out.println(Thread.currentThread().getName()+" rimuovo"+th.getName());
            inEsecuzione.remove(th);
            lock.notifyAll();
        }
}
}



}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        Runnable r1  = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
    
        Runnable r2  = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
    
        Runnable r3  = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
    
        ArrayList<Runnable> a = new ArrayList<>();
        a.add(r1); a.add(r2); a.add(r3); a.add(r1); a.add(r2);
    
        Runnable r4  = new Runnable(){
            public void run(){
                    System.out.println(Thread.currentThread().getName()+" executeInParallel");
                    Exe.executeInParallel(a,3);
                
            }
        };
    
        new Thread(r4).start();
       
    }
}