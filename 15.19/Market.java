import java.util.ArrayList;
import java.util.List;

public class Market{
    public List<Double> importi = new ArrayList<>();
    public void sell(double val) throws InterruptedException{
        synchronized(importi){
            System.out.println(Thread.currentThread().getName()+": prende monitor");
            System.out.println(Thread.currentThread().getName()+": aggiunge "+val);
            importi.add(val);
            System.out.println(Thread.currentThread().getName()+": notify all");
            importi.notifyAll();
            while(importi.contains(val)){
                System.out.println(Thread.currentThread().getName()+": wait");
            importi.wait();
            }
        }
        System.out.println(Thread.currentThread().getName()+": libero");
    }

    public void buy(double val) throws InterruptedException{
        synchronized(importi){
            System.out.println(Thread.currentThread().getName()+": prende monitor");
            while(puoComprare(val) == false){
                System.out.println(Thread.currentThread().getName()+": attende");
                importi.wait();
            }
        }
        System.out.println(Thread.currentThread().getName()+": libero");
    }

    public boolean puoComprare(double val){
        synchronized(importi){
            System.out.println(Thread.currentThread().getName()+": prende monitor");
        List<Double> tmp = importi;
        for(Double d : tmp){
            if(d.doubleValue() <= val){
                System.out.println(Thread.currentThread().getName()+": rimuove "+d.doubleValue());
            importi.remove(d);
            System.out.println(Thread.currentThread().getName()+": notifica tutti");
            importi.notifyAll();
            return true;
        }
        }
    }
    return false;
    }

}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        Market m = new Market();
        new Thread(new Runnable(){
            public void run(){
                try {
                    m.buy(10.0);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }
        }).start();
        new Thread(new Runnable(){
            public void run(){
                try {
                    m.sell (15.50); 
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }
        }).start();
        new Thread(new Runnable(){
            public void run(){
                try {
                    m.sell (12.0) ; 
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }
        }).start();
        new Thread(new Runnable(){
            public void run(){
                try {
                    m.buy(13.0); 
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }
        }).start();
        new Thread(new Runnable(){
            public void run(){
                try {
                    m.buy(11.0);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }
        }).start();
        new Thread(new Runnable(){
            public void run(){
                try {
                    m.sell (9.50) ;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }
        }).start();
        
    
    
    
     
    
    }
}
