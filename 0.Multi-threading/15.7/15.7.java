import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomExecutor{
    private List<Runnable> queue = new ArrayList<>();
    private volatile boolean lounched = false;
    private final Object mutex = new Object();

    public void addTask(Runnable r){
        if(lounched == false) queue.add(r);
    }

    public void launch(){
        synchronized(mutex){
            lounched = true;
        while( ! queue.isEmpty()){
        Random r = new Random();
        int n = r.nextInt(queue.size());
        new Thread(queue.remove(n)).start();
        mutex.notifyAll();
        }
        }

    }

    public void join(Runnable r) throws InterruptedException{
        synchronized(mutex){
            while(queue.contains(r)){
                mutex.wait();
            }
        }
    }

}

class Main{
    public static void main(String[] args) throws InterruptedException {
        RandomExecutor e = new RandomExecutor();
Runnable r1 = () -> { System.out.println(1); };
Runnable r2 = () -> { System.out.println(2); };
Runnable r3 = () -> { System.out.println(3); };
e.addTask(r1);
e.addTask(r2);
e.addTask(r3);
e.launch();
e.addTask(r3);
e. join (r2);
    }
}