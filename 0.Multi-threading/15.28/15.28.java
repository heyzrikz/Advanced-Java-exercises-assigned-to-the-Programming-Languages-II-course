import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Two{
    public static void TwoPhases(Iterable<Runnable> i1 , Iterable<Runnable> i2) throws InterruptedException{
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        final Object mutex = new Object();
        Iterator<Runnable> i11 = i1.iterator();
        Iterator<Runnable> i22 = i2.iterator();
        while(i11.hasNext()){
            queue.put(i11.next());
            queue.put(i22.next());
        }
        int size = queue.size()/2;
        for(int i = 0 ; i < size ; i++){
            new Thread(()->{
                Runnable r1 = null;
                Runnable r2 = null;
                synchronized(mutex){
                     try {
                        r1 = queue.take();
                        r2 = queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread th = new Thread(r1);
                th.start();
                try {
                    th.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Thread(r2).start();
            }).start();
        }

    }
}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        ArrayList<Runnable> a = new ArrayList<>();
        ArrayList<Runnable> b = new ArrayList<>();
        Runnable r1 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run1 terminato");
            }
        };
        Runnable r2 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run2 terminato");
            }
        };
        Runnable r3 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run3 terminato");
            }
        };
        Runnable r4 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run4 terminato");
            }
        };

        a.add(r1);
        b.add(r2);
        a.add(r3);
        b.add(r4);

        Two.TwoPhases(a, b);
        
    }
}