import java.util.concurrent.atomic.AtomicInteger;

class ThreadRace{
    public static int threadRace(Runnable r1 , Runnable r2) throws InterruptedException{
        AtomicInteger ret = new AtomicInteger(0);
        final Object mutex = new Object();
        Thread th1 = new Thread(()->{
            Thread th = new Thread(r1);
            th.start();
            synchronized(mutex){
                if(ret.get() == 0) ret.set(1);
            }
        });

        Thread th2 = new Thread(()->{
            Thread th = new Thread(r2);
            th.start();
            synchronized(mutex){
                if(ret.get() == 0) ret.set(2);
            }
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        return ret.get();

    }
}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        Runnable r1 = () -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            };

        Runnable r2 = () -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            };

        System.out.println("Vince Thread n."+ThreadRace.threadRace(r1, r2));
        
    }
}