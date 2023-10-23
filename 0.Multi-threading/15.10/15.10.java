import java.util.HashMap;
import java.util.Map;

class Shop<T>{
    private Map<T,Integer> negozio = new HashMap<>();
    private volatile Integer prezzo_minimo = null;
    private final Object mutex = new Object();

    public void sell(T object , int price){
        synchronized(mutex){
            negozio.put(object,price);
            if(prezzo_minimo == null || prezzo_minimo > price){
                prezzo_minimo = price;
                mutex.notifyAll();}
        }
    }

    public T buy(int offer) throws InterruptedException{
        synchronized(mutex){
            while(prezzo_minimo == null || offer < prezzo_minimo){
                mutex.wait();
            }
            for(T t:negozio.keySet()){
                if(offer > negozio.get(t)){
                    negozio.remove(t);
                    return t;
                }
            }
            return null;
        }
    }

}

class Main{
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
                    System.out.println(s.buy(23));
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
