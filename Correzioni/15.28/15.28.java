import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class Two{
    public static void twoPhases(Iterable<Runnable> i1 , Iterable<Runnable> i2) throws InterruptedException{
        Iterator<Runnable> iter1 = i1.iterator();
        Iterator<Runnable> iter2 = i2.iterator();
        BlockingQueue<Runnable> queue1 = new LinkedBlockingQueue<>();
        BlockingQueue<Runnable> queue2 = new LinkedBlockingQueue<>();
        while(iter1.hasNext() && iter2.hasNext()){
            queue1.put(iter1.next());
            queue2.put(iter2.next());
        }

        int size = queue1.size();
        for(int i = 0 ; i  < size ; i++){
            new Thread(()->{
                try {
                    Runnable r1 = queue1.take();
                    Runnable r2 = queue2.take();
                    r1.run();
                    r2.run();
                } catch (InterruptedException e) {
                    return;
                }
            }).start();
        }
       
    }
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
    
            Two.twoPhases(a, b);
            
        }
    }
