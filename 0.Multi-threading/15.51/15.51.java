import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ExecuteInParallel{
    public static void executeInParallel(Runnable[] arr , int k) throws InterruptedException{
        if(k > arr.length) k = arr.length;
        BlockingQueue<Thread> queue = new ArrayBlockingQueue<>(k);
        for(final Runnable r : arr){
            Thread th = new Thread(){
                public void run(){
                r.run();
                queue.remove(this);
                }
            };
            queue.put(th);
            th.start();
        }
    }
}