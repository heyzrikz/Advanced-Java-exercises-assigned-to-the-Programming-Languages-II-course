import java.util.HashSet;
import java.util.Set;

public class SharedAverage{
    private int num;
    private double totale=0;
    private int index;
    private Set<Thread> threads;
    private final Object mutex = new Object();
    public SharedAverage(int n){
        num = n;
        index = n;
        threads = new HashSet<Thread>();
    }

    public double sendValAndReceiveAvg(double val){
        synchronized(mutex){
        if(threads.contains(Thread.currentThread())) throw new RuntimeException();
        threads.add(Thread.currentThread());
        totale = totale + val;
        index--;
        mutex.notifyAll();
        while(index > 0){
            try{
                mutex.wait();
            }catch(InterruptedException i){
                i.printStackTrace();
            }
        }
        return totale/num;
       }
    }
}

class Main{
    public static void main(String[] args) {
        SharedAverage a = new SharedAverage(3);
        new Thread(){
            public void run(){
                double average;
                
                average = a.sendValAndReceiveAvg(5.0);
               
            }
        }.start();

        new Thread(){
            public void run(){
                double average;
             
                average = a.sendValAndReceiveAvg(10.0);
               
            }
        }.start();

        new Thread(){
            public void run(){
                double average;
      
                System.out.println(a.sendValAndReceiveAvg(5.0));
                
            }
        }.start();

    }
}