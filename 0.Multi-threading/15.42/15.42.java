import java.util.ArrayList;
import java.util.List;

class SharedAverage{
    
    private List<Thread> threads;
    private final Object mutex = new Object();
    private int num;
    private double tot;

    public SharedAverage(int n){
        threads = new ArrayList<Thread>();
        this.num = n;
        this.tot = 0;
    }

    public double sendValAndReceiveAvg(double val) throws InterruptedException{
        synchronized(mutex){
            if(threads.contains(Thread.currentThread())) throw new RuntimeException();
            threads.add(Thread.currentThread());
            tot = tot + val;
            mutex.notifyAll();
            while(threads.size() < num){
                mutex.wait();
            }
            return tot/num;
        }
    }

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