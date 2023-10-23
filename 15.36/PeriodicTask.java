public class PeriodicTask{
    private long time;
    public Thread exec; 
    public PeriodicTask(Runnable r , long millis){
        time = System.currentTimeMillis();
        Thread th = new Thread(new Runnable(){
            public void run(){
                while(! Thread.currentThread().isInterrupted()){
                    try{
                        Thread.sleep(millis);
                        r.run();
                    }catch(InterruptedException i){
                        return;
                    }
                }
            }
        });
        th.start();
        exec = th;
    }

    public long getTotalTime(){
        return (System.currentTimeMillis() - time);
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