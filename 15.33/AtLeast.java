import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AtLeast{
    public static void atLeastOne(int n , Runnable r) throws InterruptedException{
        BlockingQueue<Thread> queue = new ArrayBlockingQueue<>(n);
        for(int i = 0 ; i < n ; i++){
            Thread t = new Thread(new Runnable(){
                public void run(){
                    Thread th = new Thread(r);
                    try {
                        System.out.println("lancia thread");
                        th.start();
                        th.join();
                        System.out.println("finito");
                        Thread tmp;
                        while(!queue.isEmpty()){
                            if((tmp = queue.take()) != Thread.currentThread())
                                tmp.interrupt();
                        }
                    }catch(InterruptedException i){System.out.println("interrotto");return;}
                }
            });
            t.start();
            queue.put(t);
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
                    e.printStackTrace();
                }
                
            }
        };

        AtLeast.atLeastOne(5,r);
    }
}