//output:
//t2 main
//main t2
//main
 class Main {
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
        //finally {  }
        }
        });
        t1. start () ;
        t2. start () ;
        Thread.sleep(1);
        synchronized (y) {
        y. notify () ;
        }
        System.out.println("main");
        }
}

class Run{
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ; i < 10000; i++){
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
