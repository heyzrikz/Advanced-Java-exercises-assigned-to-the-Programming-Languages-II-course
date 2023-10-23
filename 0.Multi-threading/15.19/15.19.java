import java.util.ArrayList;
import java.util.List;

class Market{
    private List<Double> oggetti = new ArrayList<>();
    private final Object mutex = new Object();

    public void sell(double val){
        new Thread(()->{
            synchronized(mutex){
            oggetti.add(val);
            System.out.println(Thread.currentThread().getName()+" Metto in vendita "+val);
            mutex.notifyAll();
            while(oggetti.contains(val)){
                try{
                    System.out.println(Thread.currentThread().getName()+" Attendo che comprino val "+val);
                    mutex.wait();
                }catch(InterruptedException e){
                    return;
                }
            }
            System.out.println(Thread.currentThread().getName()+" Hanno comprato "+val);
        }
        }).start();
        
    }

    public void buy(double val){
        new Thread(()->{
            synchronized(mutex){
                System.out.println(Thread.currentThread().getName()+" Cerco < "+val);
                Double v = find(val);
                while(v == null){
                    try{
                        System.out.println(Thread.currentThread().getName()+" Aspetto che inseriscano < "+val);
                        mutex.wait();
                        v = find(val);
                    }catch(InterruptedException e){
                        return;
                    }
                }
                System.out.println(Thread.currentThread().getName()+" Ho trovato "+v);
                oggetti.remove(v);
                mutex.notifyAll();
            }
        }).start();
    }

    private Double find(double val){
        synchronized(mutex){
            for(Double d : oggetti){
                if(val > d) return d;
            }
            return null;
        }
    } 

    public static void main(String[] args) {
        Market m =  new Market();
        m.buy(10.0); 
 m.sell (15.50); 
 m.sell (12.0) ; 
 m.buy(13.0);
 m.buy(11.0); 
 m.sell (9.50) ;
        
    }

}