import java.util.HashMap;
import java.util.Map;

class Exchange{
    private Map<String,Number> titoli = new HashMap<>();
    private final Object mutex = new Object();
    
    public void setPrice(String name, Double value){
        synchronized(mutex){
            titoli.put(name,value);
            mutex.notifyAll();
        }
    }

    public void addLowAlert(String name, Double value, Runnable r){
        new Thread(()->{
            synchronized(mutex){
                while(titoli.get(name) != null && titoli.get(name).doubleValue() > value){
                    try{
                        mutex.wait();
                    }catch(InterruptedException e){
                        return;
                    }
                }
                new Thread(r).start();

            }
        }).start();
    }

    public void addHighAlert(String name, Number value, Runnable r){
        new Thread(()->{
            synchronized(mutex){
                while(titoli.get(name) != null && titoli.get(name).doubleValue() < value.doubleValue()){
                    try{
                        mutex.wait();
                    }catch(InterruptedException e){
                        return;
                    }
                }
                new Thread(r).start();

            }
        }).start();
    }

    public static void main(String[] args) {
        Exchange borsa = new Exchange();
        borsa.setPrice("MaxiCom",10.56);
        borsa.setPrice("MegaCorp",18.2);
        borsa.setPrice("SuperMarkt",3.91);
        borsa.addLowAlert("MegaCorp",17.5,() ->{System.out.println("Below the threshold!");});
        borsa.addHighAlert("MaxiCom",12,() ->{System.out.println("More than 12!");});
        borsa.addHighAlert("MaxiCom",20.5,() ->{System.out.println("More than 20.5!");});
        borsa.setPrice("MaxiCom",12.3);
        
    }
}