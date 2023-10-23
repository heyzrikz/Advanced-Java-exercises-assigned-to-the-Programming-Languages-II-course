class PeriodicTask{
    private long time;
    public Thread exec = Thread.currentThread();
    public PeriodicTask(Runnable r , long millis) throws InterruptedException{
        time = System.currentTimeMillis();
        while(!Thread.currentThread().isInterrupted()){
            Thread th = new Thread(r);
            th.start();
            th.join();
            Thread.sleep(millis);
        }
    }

    public long getTotalTime(){
        return System.currentTimeMillis() - time;
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            public void run() {
            System.out.println("Ciao!");
            }
            };
            PeriodicTask p = new PeriodicTask(r, 2000);
            Thread.sleep(10000);
            p.exec.interrupt();
            System.out.println("Total time: "+p.getTotalTime());
    }
}