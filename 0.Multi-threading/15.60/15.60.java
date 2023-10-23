import java.util.HashMap;
import java.util.Map;

class Highway{
    private int lunghezza;
    private final Object mutex = new Object();
    private Map<Thread,Integer> km = new HashMap<>();

    public Highway(int lunghezza){
        this.lunghezza = lunghezza;
    }

    public void progress(){
        synchronized(mutex){
            mutex.notifyAll();
        }
    }

    public void insertCar(int n){
        new Thread(()->{
            synchronized(mutex){
                km.put(Thread.currentThread(),n);
                int index = n;
                while(n < lunghezza){
                    try{
                        mutex.wait();
                        index++;
                        km.put(Thread.currentThread(),index);
                    }catch(InterruptedException i){
                        return;
                    }
                }
            }
        }).start();
    }

    public int nCars(int n) throws InterruptedException{
        int ret = 0;
        Thread.sleep(4000);
        synchronized(mutex){
        for(Integer i : km.values()){
            if(i == n) ret++;
        }
    }
        return ret;
    }

    public static void main(String[] args) throws InterruptedException {
        Highway h = new Highway(10);
        h.insertCar(3); h.insertCar(3); h.insertCar(5);
        System.out.println(h.nCars(4));
        h.progress() ;
        System.out.println(h.nCars(4));  
    }
}