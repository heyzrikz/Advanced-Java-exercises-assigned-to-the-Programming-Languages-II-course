import java.util.ArrayList;
import java.util.List;

public class Exe{
    private static int count = 0;
    private static int i = 0;
    private final static Object lock = new Object();
    public static void executeInParallel(Runnable r, int k){
        synchronized(lock){
            while(! isDone()){
        while(i < k){
            System.out.println(Thread.currentThread().getName()+" creo thread");
            Thread th = new Thread(r);
            th.start();
            count++;
            i++;
        while((count >= k)){
            System.out.println(Thread.currentThread().getName()+" entro in attesa");
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            }
    } 
}
}

private static void aggiornoList(){
    
}

private static boolean isDone(){
    if(count < 5) return false;
    return true;
}



}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        Runnable r4  = new Runnable(){
            public void run(){
                    System.out.println(Thread.currentThread().getName()+" executeInParallel");
                    Exe.executeInParallel(new Runnable() {
                        public void run(){
                            try {
                                System.out.println(Thread.currentThread().getName()+" inizio");
                                Thread.sleep(3000);
                                System.out.println(Thread.currentThread().getName()+" finisco");
                                
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    },3);
                
            }
        };
    
        Thread th = new Thread(r4);
        th.start();
        th.join();
        System.out.println(Thread.currentThread().getName()+"fine");

       
    }
}