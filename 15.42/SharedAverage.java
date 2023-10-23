import java.util.HashSet;
import java.util.Set;

public class SharedAverage{
    private int number;
    private int count;
    private Object mutex = new Object();
    private double totale;
    private Set<Thread> threads = new HashSet<>();

    public SharedAverage(int number){
        this.number = number;
        count = number;
        totale = 0;
    }

    public double sendValAndReceiveAvg(double val) throws InterruptedException{
            synchronized(mutex){
            System.out.println(Thread.currentThread().getName()+" metodo");
            if(threads.contains(Thread.currentThread())) throw new RuntimeException("Thread già chiamato");
            threads.add(Thread.currentThread());
            totale = totale + val;
            number--;
            mutex.notifyAll();
            while(number > 0){
                mutex.wait();
            }
            return totale/count;
        }
    }
}

class Main{
    public static void main(String[] args) {
        SharedAverage a = new SharedAverage(3);
        
        new Thread(){
        public void run(){
            try {
                double average;
                average = a.sendValAndReceiveAvg(10.0);
            } catch (InterruptedException e) {
            return;
            }
        }}.start();
        new Thread(){
            public void run(){
                try {
                    double average;
                    average = a.sendValAndReceiveAvg(5.0);
                } catch (InterruptedException e) {
                return;
                }
            }}.start();
            new Thread(){
                public void run(){
                    try {
                        double average;
                        System.out.println(a.sendValAndReceiveAvg(5.0));
                    } catch (InterruptedException e) {
                    return;
                    }
                }}.start();
        

    }
}