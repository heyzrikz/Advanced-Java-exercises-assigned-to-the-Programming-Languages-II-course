import java.util.HashMap;
import java.util.Map;

public class TimeToFinish{
    private Map<Thread,Long> threads;
    private Object mutex = new Object();
    TimeToFinish(){
        threads = new HashMap<Thread,Long>();
    }

    public void setEstimate(long millis){
        synchronized(mutex){
        threads.put(Thread.currentThread(),System.currentTimeMillis() + millis);
        }
    }

    public long maxTimeToFinish(){
        synchronized(mutex){
            return threads.get(Thread.currentThread()) - System.currentTimeMillis();
        }
    }

    public String toString(){
        String ret="";
        synchronized(mutex){
        long tmp;
        for(Thread th : threads.keySet()){
            tmp = threads.get(th) - System.currentTimeMillis();    
            ret=ret+th.getName()+": "+tmp+"\n";
        }
        }
        return ret;
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        TimeToFinish ttf = new TimeToFinish();
        ttf .setEstimate(5000);
        Thread th1 = new Thread(){
            public void run(){
                ttf .setEstimate(3000);                
            }
        };
        th1.start();
        // a questo punto un altro thread invoca ttf .setEstimate(3000)
        Thread.sleep(500);
        System.out.println("Tempo rimanente: " + ttf.maxTimeToFinish() + " millisecondi.");
        System.out.println( ttf );
    }
}