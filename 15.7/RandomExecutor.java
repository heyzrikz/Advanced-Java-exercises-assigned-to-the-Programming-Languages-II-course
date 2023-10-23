import java.util.HashMap;
import java.util.Map;

public class RandomExecutor{
    Map<Runnable,Thread> tasks = new HashMap<>();
    public void launch(){
        if(tasks.keySet().isEmpty()) throw new RuntimeException("Eseguito launch prima di addTasks");
        for(Runnable r : tasks.keySet()){
            tasks.get(r).start();
        }
    }

    public void addTask(Runnable r){
        tasks.put(r,new Thread(r));
    }

    public void join(Runnable r) throws InterruptedException{
        if(tasks.get(r) != null && ! tasks.get(r).isInterrupted())
            tasks.get(r).join();
    }


}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        RandomExecutor e = new RandomExecutor();
    Runnable r1 = () -> { System.out.println(1); };
    Runnable r2 = () -> { System.out.println(2); };
    Runnable r3 = () -> { System.out.println(3); };
    e.addTask(r1);
    e.addTask(r2);
    e.addTask(r3);
    e.launch();
    e. join (r2);
    System.out.println("fine");
    }
}