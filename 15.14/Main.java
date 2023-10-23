/*
2 1 Fatto
2 Fatto 1
1 2 Fatto
2 3 Fatto
2 Fatto 3
3 2 Fatto

*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Object x = new Object();
        final int [] count = new int[1]; // don’t do this : use AtomicInteger
        class MyThread extends Thread {
        int id;
        MyThread(int n) { id = n; }
        public void run() {
        synchronized (x) {
        synchronized (count) {
        count[0]++;
        count.notify () ;
        }
        try {
        x.wait();
        } catch (Exception e) {
        x. notify () ;
        } finally {
        System.out.println(id);
        }
        }
        }
        }
        Thread t1 = new MyThread(1), t2 = new MyThread(2), t3 = new MyThread(3);
        t1. start () ; t2. start () ; t3. start () ;
        synchronized (count) {
        while (count[0]<3) count.wait();
        }
        t2. interrupt () ;
        t2. join () ;
        System.out.println("Fatto");
        }
    
}
