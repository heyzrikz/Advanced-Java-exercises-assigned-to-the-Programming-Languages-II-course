import java.util.HashMap;
import java.util.Map;

public class Shop<T>{
    private Map<T,Integer> oggetti = new HashMap<>();

    public synchronized void sell(T object , int price) throws InterruptedException{
      
            System.out.println(Thread.currentThread().getName()+": prende monitor");
            oggetti.put(object,price);
            System.out.println(Thread.currentThread().getName()+": notifica tutti");
            notifyAll();
            //Thread.sleep(1000); //per sincronizzazione, è una finezza
    }

    public synchronized T buy(int offer) throws InterruptedException{
        
            System.out.println(Thread.currentThread().getName()+": prende monitor");
            T ret = null;
            while((ret = cercaOggetti(offer)) == null){
                System.out.println(Thread.currentThread().getName()+": wait ");
                wait();
                System.out.println(Thread.currentThread().getName()+": si sveglia");
            }
            oggetti.remove(ret);
            return ret;
        }
    


public T cercaOggetti(int offer){
    for(T t : oggetti.keySet()){
        if(oggetti.get(t) <= offer) return t;
        
    }
    return null;
}

}
class Main{
    public static void main(String arg[]){
        Shop<String> s = new Shop<>();
        Runnable r1 = new Runnable(){
            public void run(){
                try {
                    s.sell("Armadio",50);
                    s.sell("Tavolo",70);
                    s.sell("Sedia",20);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               
            }
        };

        Runnable r2 = new Runnable(){
            public void run(){
                try {
                    s.sell("Cappello",15);
                    s.sell("Tavolo",50);
                    s.sell("TV",120);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               
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
