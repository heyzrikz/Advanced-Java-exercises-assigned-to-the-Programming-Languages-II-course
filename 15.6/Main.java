public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Object x = new Object(), y = new Object();
        Thread t1 = new Thread(() -> {
        synchronized (x) {
        try {
        x.wait();
        synchronized (y) {
        y. notify () ;
        }
        }
        catch (Exception e) { return; }
        finally { System.out.println("t1"); }
        }
        });
        Thread t2 = new Thread(() -> {
        synchronized (y) {
            try { y.wait(); }
catch (Exception e) { return; }
 System.out.println("t2"); 
}
});
t1. start () ;
t2. start () ;
Thread.sleep(100);
synchronized (y) {
y. notify () ;
Thread.sleep(1000);
System.out.println("main");
}

}
}
