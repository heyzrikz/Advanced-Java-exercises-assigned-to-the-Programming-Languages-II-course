import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Shop<T>{
    private Map<T,Integer> oggetti = new HashMap<>();
    private volatile Integer min_price = null;
    private volatile T min_obj = null;
    private final Object mutex = new Object();

    public void sell(T obj, int price){
        synchronized(mutex){
            oggetti.put(obj,price);
            findMin();
            mutex.notifyAll();
        }
    }

    public T buy(int offer) throws InterruptedException{
        synchronized(mutex){
            while(min_price == null || min_price > offer){
                mutex.wait();
            }
            T ret = min_obj;
            oggetti.remove(min_obj);
            findMin();
            return ret;
        }
    }

    private void findMin(){
        synchronized(mutex){
            min_price = null;
            for(T t : oggetti.keySet()){
                if(min_price == null || oggetti.get(t) < min_price){
                    min_obj = t;
                    min_price = oggetti.get(t);
                }
            }
        }
    }

    public static void main(String arg[]){
        Shop<String> s = new Shop<>();
        Runnable r1 = new Runnable(){
            public void run(){
                    s.sell("Armadio",50);
                    s.sell("Tavolo",70);
                    s.sell("Sedia",20);
                
               
            }
        };

        Runnable r2 = new Runnable(){
            public void run(){
                    s.sell("Cappello",15);
                    s.sell("Tavolo",50);
                    s.sell("TV",120);
               
               
            }
        };

        Runnable r3 = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(10000);
                    int i = 1;
                    System.out.println(i+" compra: "+s.buy(23));
                    i++;
                    System.out.println(i+" compra: "+s.buy(51));
                    i++;
                    System.out.println(i+" compra: "+s.buy(51));
                    i++;
                    System.out.println(i+" compra: "+s.buy(71));

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t3 = new Thread(r3);
        Thread t2 = new Thread(r2);
        t3.start();
        t1.start();
        t2.start();
    }
}