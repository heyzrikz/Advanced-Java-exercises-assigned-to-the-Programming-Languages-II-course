import java.util.ArrayList;
import java.util.List;

public class Esercizio{
private static List<Thread> threadInVita = new ArrayList<>();
private static final Object lock = new Object();
private static Runnable verificaThread = new Runnable(){
    public void run(){
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()+" prendo monitor");
            List<Thread> local = new ArrayList<>(threadInVita);
            for(int i=0 ; i < local.size(); i++){
                if( ! local.get(i).isAlive()){
                    System.out.println(Thread.currentThread().getName()+" elimino "+local.get(i).getName());
                    threadInVita.remove(local.get(i));
                    System.out.println(Thread.currentThread().getName()+" notifico");
                    lock.notifyAll();
                    i = local.size();
                } else if(i == local.size() - 1){ i = 0;
                    local = new ArrayList<>(threadInVita);
                }
            }
        }
    }
};

public static void executeInParallel(ArrayList<Runnable> r , int k) throws InterruptedException{
    synchronized(lock){
        System.out.println(Thread.currentThread().getName()+" prendo monitor");
        for(int i = 0 ; i < r.size() ; i++){
            if(threadInVita.size() < k){
                System.out.println(Thread.currentThread().getName()+" creo Thread n."+i);
                Thread th = new Thread(r.get(i));
                th.start();
                threadInVita.add(th);
            }

            while(threadInVita.size() >= k){
                System.out.println(Thread.currentThread().getName()+" lancio verificaThread");
                new Thread(verificaThread).start();
                System.out.println(Thread.currentThread().getName()+" Aspetto");
                lock.wait();
                System.out.println(Thread.currentThread().getName()+" prendo monitor");
            }
        }
    }
    System.out.println(Thread.currentThread().getName()+" Attendo terminazione altri thread");
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
                    try {
                        Esercizio.executeInParallel(a,3);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                
            }
        };
    
        new Thread(r4).start();
       
    }
}