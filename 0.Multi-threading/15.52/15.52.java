import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class QueueOfTasks{
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    public QueueOfTasks(){
        new Thread(()->{
            while(! Thread.currentThread().isInterrupted()){
                try{
                Thread th = new Thread(queue.take());
                th.start();
                th.join();
                }catch(InterruptedException i){
                    return;
                }
            }
        }).start();
    }

    public void add(Runnable r) throws InterruptedException{
        queue.put(r);
    }

    public static void main(String[] args) throws InterruptedException{
        QueueOfTasks q = new QueueOfTasks();
Runnable r1 = new Runnable() {
public void run() {
try { Thread.sleep(2000); }
catch (InterruptedException e) { return;
}
System.out.println("Io adoro i thread!");
}
};
Runnable r2 = new Runnable() {
public void run() {
System.out.println("Io odio i thread!");
}
};
q.add(r1);
q.add(r1);
q.add(r2);
System.out.println("fatto .");

    }

}