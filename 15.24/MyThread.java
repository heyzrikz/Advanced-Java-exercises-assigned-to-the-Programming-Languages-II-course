import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger i = new AtomicInteger(0);
    public void run() {
        synchronized (this){//_____1_____
            System.out.println(Thread.currentThread().getName()+" : prende mutex");
    //_____2_____
    System.out.println(Thread.currentThread().getName()+" : incremento");
    i.incrementAndGet();
    //_____3_____
    
}//_____4_____
    }
    }

    class Main{
        public static void main(String arg[]) throws InterruptedException{
            MyThread th = new MyThread();
            MyThread th2 = new MyThread();
            th.start();
            th2.start();
            th.join();
            th2.join();
            System.out.println(MyThread.i.get());
        }
    }
