import java.util.HashMap;
import java.util.Map;

class Exchanger<T>{
    private Map<Thread,T> elementi = new HashMap<>();
    private final Object mutex = new Object();
    
    public T exchange(T val) throws InterruptedException{
        synchronized(mutex){
            if(elementi.get(Thread.currentThread()) != null || elementi.size() == 2) throw new RuntimeException("Non si può effettuare uno scambio nello stesso thread");
            elementi.put(Thread.currentThread(),val);
            mutex.notify();
            while(elementi.size() != 2){
                mutex.wait();
            }
            for(Thread t : elementi.keySet()){
                if(t != Thread.currentThread()) return elementi.get(t);
            }
            return null;
        }
    } 
    public static void main(String[] args) {
        Exchanger<String> e = new Exchanger<String>();
        new Thread(new Runnable(){
            public void run(){
                String a;
                try {
                    a = e.exchange("ciao");
                    System.out.println(a);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){
                String a="";
                try {
                    a = e.exchange("Pippo");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                    
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.out.println(a);
            }
        }).start();
    }
}