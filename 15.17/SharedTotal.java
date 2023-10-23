import java.util.ArrayList;
import java.util.List;

public class SharedTotal{
    private static List<Thread> threads;
    private List<Double> valori;

    SharedTotal(int mill){
        threads = new ArrayList<Thread>();
        valori = new ArrayList<Double>();
        new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName()+": dormo");
                    Thread.sleep(mill);
                    System.out.println(Thread.currentThread().getName()+": non dormo più");
                    synchronized(valori){
                        System.out.println(Thread.currentThread().getName()+": prende monitor");
                        System.out.println(Thread.currentThread().getName()+": notifica tutti");
                        valori.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
                
            }
        }).start();
       
    }



    public double sendValAndReceiveTot(double val) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+": entro in funzione");
        synchronized(threads){
            if(threads.contains(Thread.currentThread())) throw new RuntimeException("Questo thread ha già eseguito questo metodo");
            else threads.add(Thread.currentThread());
        }
        double ret = 0;
        synchronized(valori){
            System.out.println(Thread.currentThread().getName()+": prende monitor");
            valori.add(val);
            System.out.println(Thread.currentThread().getName()+": wait");
            valori.wait();
            System.out.println(Thread.currentThread().getName()+": si sveglia");
            for(Double d : valori){
                ret = ret + d;
            }
        }
        return ret;
    }



}

class Main{
    public static void main(String arg[]){
        SharedTotal tot = new SharedTotal(1000);
        new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println(tot.sendValAndReceiveTot(5.0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println(tot.sendValAndReceiveTot(10.0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}