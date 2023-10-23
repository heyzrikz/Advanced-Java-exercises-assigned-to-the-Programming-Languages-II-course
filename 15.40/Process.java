import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Process{
    public static <T> void processArray(T[] x , T[] y , RunnableFunction<T> f , int n) throws InterruptedException{
        BlockingQueue<T> queue = new ArrayBlockingQueue<>(n);
        AtomicInteger index = new AtomicInteger(0);
        for(int i = 0 ; i < x.length; i++){
            queue.put(x[i]);
            new Thread(new Runnable(){
                public void run(){
                    synchronized(index){
                        try{
                        Thread.sleep(2000);
                        y[index.get()] = f.run(x[index.get()]);
                        queue.take();
                        index.incrementAndGet();
                    }catch(InterruptedException i){
                        return;
                    }
                }
                }
            }).start();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        String [] x = {"uno", "due", "tre"}, y = new String[3];
RunnableFunction<String> f = new RunnableFunction<String>() {
public String run(String x) {
return x + x;
}
};

Thread th = new Thread(){
    public void run(){
    try {
        processArray(x, y, f , 2);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }}
};
th.start();
th.join();
Thread.sleep(10000);
for (String s: y)
System.out.println(s);
    }
}