/*
 T2:A T1:A T2:B T1:B Fine
 T1:A T2:A T2:B T1:B Fine
 T2:A T1:A T1:B T2:B Fine 
 T1:A T2:A T1:B T2:B Fine
 T2:A T1:A T1:B Fine T2:B 
 T1:A T2:A T1:B Fine T2:B 

 T2:A T2:B ...
 T2:A T1:B Fine T2:B 
 T2:A T2:B T1:B Fine
 
 */

class Main{
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

class Run{
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ; i < 100; i++){
            Thread th = new Thread(()->{try {
                Main.main(args);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }});
            th.start();
            th.join();
            System.out.println("");
            
        }
    }
}