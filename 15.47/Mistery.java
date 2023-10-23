public class Mistery {
    public static void main(String[] args) throws InterruptedException {
        final Object dummy = new Object();
        final Thread t1 = new Thread() {
        public void run() {
        synchronized (dummy) {
        while (true) {
        try { dummy.wait(); System.out.println("T1:A"); }
        catch (InterruptedException e) { break; }
        }
        System.out.println("T1:B");
        }
        }
        };
        final Thread t2 = new Thread() {
        public void run() {
        synchronized (dummy) {
        dummy.notifyAll();
        System.out.println("T2:A");
        }
        t1. interrupt () ;
        System.out.println("T2:B");
        }
        };
        t1. start () ;
        t2. start () ;
        t1. join () ;
        System.out.println("Fine");
        }  
    
}
