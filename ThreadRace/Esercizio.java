import java.util.concurrent.atomic.AtomicInteger;

public class Esercizio{

    private static final Object lock = new Object();
    private static Thread concorrente1;
    private static Thread concorrente2;
    private static Thread vincitore = null;

    public static int threadRaceV1(Runnable r1 , Runnable r2) throws InterruptedException{
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()+" prendo monitor");
        concorrente1 = new Thread(r1);
        concorrente2 = new Thread(r2);
        concorrente1.start();
        concorrente2.start();
        new Thread(new Runnable(){
            public void run(){
                synchronized(lock){
                    System.out.println(Thread.currentThread().getName()+" prendo monitor");
                    while(concorrente1.isAlive() || concorrente2.isAlive()){
                        if( ! concorrente1.isAlive()){
                            vincitore = concorrente1;
                        }else if( ! concorrente2.isAlive()){
                            vincitore = concorrente2;
                        }
                    }
                    lock.notifyAll();
                   
                }
            }
        }).start();
        while(vincitore == null){
            System.out.println(Thread.currentThread().getName()+" Attendo");
            lock.wait();
        }
    }
    if(vincitore == concorrente1) return 1;
    else return 2;
}


public static int threadRaceV2(Runnable r1 , Runnable r2) throws InterruptedException{
    synchronized(lock){
        System.out.println(Thread.currentThread().getName()+" prendo monitor");
    concorrente1 = new Thread(r1);
    concorrente2 = new Thread(r2);
    concorrente1.start();
    concorrente2.start();
    new Thread(new Runnable(){
        public void run(){
            synchronized(lock){
                System.out.println(Thread.currentThread().getName()+" prendo monitor");
                while(concorrente1.isAlive() && concorrente2.isAlive()){}
                if( ! concorrente1.isAlive()){
                    vincitore = concorrente1;
                }else if( ! concorrente2.isAlive()){
                    vincitore = concorrente2;
                }
                lock.notifyAll();
               
            }
        }
    }).start();
    while(vincitore == null){
        System.out.println(Thread.currentThread().getName()+" Attendo");
        lock.wait();
    }
}
if(vincitore == concorrente1) return 1;
else return 2;
}

public static int threadRaceV1_(Runnable r1 , Runnable r2) throws InterruptedException{
    AtomicInteger vincitore = new AtomicInteger(0);
    Thread th1 = new Thread(new Runnable(){
        public void run(){
            Thread t = new Thread(r1);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            vincitore.set(1);

        }
    });
    Thread th2 = new Thread(new Runnable(){
        public void run(){
            Thread t = new Thread(r2);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            vincitore.set(2);

        }
    });
    th1.start();
    th2.start();
    th1.join();
    th2.join();
    if(vincitore.get() == 1) return 2;
    else return 1;

}

public static int threadRaceV2_(Runnable r1 , Runnable r2) throws InterruptedException{
    AtomicInteger vincitore = new AtomicInteger(0);
    Thread th1 = new Thread(new Runnable(){
        public void run(){
            Thread t = new Thread(r1);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized(vincitore){
                vincitore.set(1);
                vincitore.notifyAll();
            }
            

        }
    });
    Thread th2 = new Thread(new Runnable(){
        public void run(){
            Thread t = new Thread(r2);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized(vincitore){
            vincitore.set(2);
            vincitore.notifyAll();
        }

        }
    });
    th1.start();
    th2.start();
    synchronized(vincitore){
        while(vincitore.get() == 0)
        vincitore.wait();
    }
    return vincitore.get();

}

}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        Runnable r1 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        System.out.println("Vince Thread n."+Esercizio.threadRaceV2_(r1, r2));
        
    }
}