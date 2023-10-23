import java.util.HashMap;
import java.util.Map;

class TimeToFinish{
    private Map<Thread,Long> threads;
    private final Object mutex = new Object();
    public TimeToFinish(){
        threads = new HashMap<Thread,Long>();
    }

    public void setEstimate(long dur){
        synchronized(mutex){
            threads.put(Thread.currentThread(),System.currentTimeMillis() + dur);
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
        for(Thread th:threads.keySet()){
            long val = threads.get(th) - System.currentTimeMillis();
            ret=ret+th.getName()+": "+val+"\n";
        }
        return ret;
        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        TimeToFinish ttf = new TimeToFinish();
ttf .setEstimate(5000);
new Thread(){
    public void run(){
        ttf.setEstimate(3000);
    }
}.start();
Thread.sleep(500);
System.out.println("Tempo rimanente: " + ttf.maxTimeToFinish() + " millisecondi.");
System.out.println( ttf );
    
    }


}