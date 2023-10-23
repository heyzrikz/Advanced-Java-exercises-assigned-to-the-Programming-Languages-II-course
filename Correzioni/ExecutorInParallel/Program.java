import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Executor{
    public void executorInParallel(Runnable[] a ,int n) throws InterruptedException{
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(Arrays.asList(a));
        List<Thread> threads = new ArrayList<>();
        AtomicInteger size = new AtomicInteger(queue.size());
        final Object mutex = new Object();
        for(int i = 0 ; i < n ; i++){
            Thread th = new Thread(()->{
                while( ! Thread.currentThread().isInterrupted()){
                    try{
                    queue.take().run();
                    synchronized(mutex){
                        size.decrementAndGet();
                        mutex.notify();
                    }
                }catch(InterruptedException e){
                    return;
                }
            }
            });
            threads.add(th);
            th.start();
        }

        synchronized(mutex){
            while(size.get() > 0){
                mutex.wait();
            }
        }
        
        for(Thread th : threads){
            th.interrupt();
        }
    }
}