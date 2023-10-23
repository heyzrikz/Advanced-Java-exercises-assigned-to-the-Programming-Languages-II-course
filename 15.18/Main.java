//stampa:
//(numero da 1 a 3) 4
//4 (numero da 1 a 3)

public class Main {
    public static void main(String[] args) throws InterruptedException {
        class MyThread extends Thread {
        private int id;
        private Object object;
        public MyThread(int n, Object x) {
        id = n;
        object = x;
        }
        public void run() {
        try {
        synchronized (object) {
        object.wait();
        }
        } catch (InterruptedException e) {
        return;
        }
        System.out.println(id);
        }
        }
        Object o1 = new Object(), o2 = new Object();
        Thread t1 = new MyThread(1,o1);
        Thread t2 = new MyThread(2,o1);
        Thread t3 = new MyThread(3,o1);
        Thread t4 = new MyThread(4,o2);
         t1. start () ; t2. start () ; t3. start () ; t4. start () ;
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        synchronized (o2) { o2.notifyAll(); }
        synchronized (o1) { o1.notify(); }
        }
}

class Run {

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<100; i++){
            Main.main(args);
            
        }
    }
}