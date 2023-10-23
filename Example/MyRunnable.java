public class MyRunnable implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getId()+"run()");
        synchronized (this) {
            System.out.println(Thread.currentThread().getId()+"Prendo monitor");
            try {
                System.out.println(Thread.currentThread().getId()+"Aspetto");
                this.wait(5000);
                System.out.println(Thread.currentThread().getId()+"Thread in runnable state");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 class IllegalMonitorStateExceptionExample {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        Thread myThread2 = new Thread(myRunnable);
        myThread.start();
        myThread2.start();
    }
}