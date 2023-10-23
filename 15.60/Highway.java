import java.util.HashMap;
import java.util.Map;

public class Highway{
    private int lunghezza;
    private Map<Thread,Integer> strada;
    private Object mutex = new Object();
    public Highway(int lunghezza){
        this.lunghezza = lunghezza;
        strada = new HashMap<Thread,Integer>();
    }

    public void insertCar(int km){
        if(km > lunghezza) throw new RuntimeException();
        new Thread(new Runnable(){
            public void run(){
                synchronized(mutex){
                    strada.put(Thread.currentThread(),km);
                    while(strada.get(Thread.currentThread()) < lunghezza){
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        strada.put(Thread.currentThread(),strada.get(Thread.currentThread()) + 1);
                    }
                } 
            }
        }).start();
    }

    public void progress(){
        synchronized(mutex){
            mutex.notifyAll();
        }
    }

    public int nCars(int km) throws InterruptedException{
        Thread.sleep(2000);
        synchronized(mutex){
            int ret = 0;
            for(Thread t : strada.keySet()){
                if(strada.get(t) == km) ret++;
            }
            return ret;
        }
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        Highway h = new Highway(10);
        h.insertCar(3); h.insertCar(3); h.insertCar(5);
        System.out.println(h.nCars(4));
        h.progress() ;
        System.out.println(h.nCars(4));  
    }
}