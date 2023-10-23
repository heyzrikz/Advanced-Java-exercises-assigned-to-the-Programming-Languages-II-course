import java.util.concurrent.atomic.AtomicInteger;

public class PeriodicExecutor{
    private AtomicInteger number;
    PeriodicExecutor(int n){
        number = new AtomicInteger(n);
    }
    public void addTask(Runnable r , int deelay){
        new Thread(new Runnable(){
            public void run(){
                    try {
                        while(true){
                            synchronized(number){
                                while(number.get() <= 0){
                                    number.wait();
                                }
                                number.decrementAndGet();
                            }
                             Thread th = new Thread(r);
                            th.start();
                            th.join();
                            synchronized(number){
                                number.incrementAndGet();
                                number.notifyAll();
                            }
                            Thread.sleep(deelay);
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                    

                
            }
        }).start();
        
    }
    }

    class Main{
        public static void main(String arg[]){
            PeriodicExecutor exec = new PeriodicExecutor(2);
        Runnable r1 = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("th1");
            }
        }, r2 = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("th2");
            }
        }, r3 = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("th3");
            }
        }, r4 = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("th4");
            }
        };
        exec.addTask(r1, 1000);
        exec.addTask(r2, 500);
        exec.addTask(r3, 700);
        exec.addTask(r4, 200);
        }
    }
