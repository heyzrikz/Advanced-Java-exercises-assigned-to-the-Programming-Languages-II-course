public class Interruptor extends Thread{
    private Thread t;
    private int sec;
    Interruptor(Thread t, int i) throws InterruptedException{
        this.t = t;
        this.sec = i*1000;
        this.start();
    }

    public void run(){
        t.start();
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t.interrupt();
    }
}