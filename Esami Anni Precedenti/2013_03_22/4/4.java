import java.util.HashSet;
import java.util.Set;

class SharedAverage{
    private int num;
    private double tot;
    private Set<Thread> threads = new HashSet<>();
    private final Object mutex = new  Object();
    
    public SharedAverage(int num){
        this.num = num;
    }

    public double sendValAndReceiveAvg(double val) throws InterruptedException{
        synchronized(mutex){
        if(threads.contains(Thread.currentThread())) throw new RuntimeException("Thread ha già invocato questo metodo");
        threads.add(Thread.currentThread());
        tot = tot + val;
        mutex.notifyAll();
            while(threads.size() < num){
                mutex.wait();
            }
        }
        double ret = tot / num;
        return ret;
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