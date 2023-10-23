import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class PeriodicExecutor{
private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

public PeriodicExecutor(int num){
    for(int i = 0 ; i < num ; i++){
        new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                try{
                queue.take().run();
                }catch(InterruptedException e){
                    return;
                }
            }
        }).start();
    }
}



public void addTask(Runnable r , long millis) {
    new Thread(()->{
        while(! Thread.currentThread().isInterrupted()){
            try{
            queue.put(r);
            Thread.sleep(millis);
            }catch(InterruptedException i){
                return;
            }
    }
    }).start();
    
}
}


class UseCase{
    public static void main(String arg[]) throws InterruptedException{
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