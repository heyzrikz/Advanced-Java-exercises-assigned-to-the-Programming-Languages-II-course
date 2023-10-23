import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class PeriodicExecutor{
    private BlockingQueue<Runnable> queue;
    
    public PeriodicExecutor(int limit){
        queue = new ArrayBlockingQueue<Runnable>(limit);

    }

    public void addTask(Runnable r , long time){
        new Thread(()->{
             while(! Thread.currentThread().isInterrupted()){
                try{
                queue.put(r);
                Thread th = new Thread(r);
                th.start();
                th.join();
                queue.remove(r);
                Thread.sleep(time);
                }catch(InterruptedException i){
                    return ;
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("th1");
        }
    }, r2 = new Runnable(){
        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("th2");
        }
    }, r3 = new Runnable(){
        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("th3");
        }
    };
    exec.addTask(r1, 1000);
    exec.addTask(r2, 500);
    exec.addTask(r3, 700);
    }
}