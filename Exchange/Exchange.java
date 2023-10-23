import java.util.HashMap;
import java.util.Map;

public class Exchange{
    Map<String,Double> titles;
    Exchange(){
        titles = new HashMap<String,Double>();
    }

    public  void setPrice(String name, double price){
        synchronized(titles){
        titles.put(name,price);
        titles.notifyAll();
        }
    }

    public void addLowAlert(String name, double price, Runnable r){
        new Thread(){
            public void run(){
                synchronized(titles){
                if(titles.get(name) == null) throw new RuntimeException(name+" non esiste questo titolo");
                while(titles.get(name) > price){
                    try {
                        titles.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
                new Thread(r).start();
            }
        }.start();
    }

    public void addHighAlert(String name, double price, Runnable r){
        new Thread(){
            public void run(){
                synchronized(titles){
                if(titles.get(name) == null) throw new RuntimeException(name+" non esiste questo titolo");
                while(titles.get(name) < price){
                    try {
                        titles.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
                new Thread(r).start();
            }
        }.start();
    }
}

class Main{
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