import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

interface RunnableFunction<T>{
    public T run(T x);
}

class Process{
    public static <T> void processArray(T[] x , T[] y , RunnableFunction<T> f , int n) throws InterruptedException{
        BlockingQueue<T> queue = new LinkedBlockingQueue<>(Arrays.asList(x));
        AtomicInteger index = new AtomicInteger(0);
        Set<Thread> threads = new HashSet<>();
        final Object mutex = new Object();

        for(int i = 0 ; i < n ; i++){
            Thread th = new Thread(()->{
              try{
                while(! Thread.currentThread().isInterrupted()){
                synchronized(mutex){
                    y[index.get()] = f.run(queue.take());
                    index.incrementAndGet();
                    mutex.notifyAll();
                    }
                }
              }catch(InterruptedException e){
                return;
              } 
            });
            threads.add(th);
            th.start();
        }
        synchronized(mutex){
        while(index.get() < x.length){
            mutex.wait();
        }

        for(Thread th : threads){
          th.interrupt();
        }
        }
        

    }

    public static void main(String[] args) throws InterruptedException {
      String [] x = {"uno", "due", "tre"}, y = new String[3];
RunnableFunction<String> f = new RunnableFunction<String>() {
public String run(String x) {
return x + x;
}
};
processArray(x, y, f , 2);
for (String s: y)
System.out.println(s);
    }
}