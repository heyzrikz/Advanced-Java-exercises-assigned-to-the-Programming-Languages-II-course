class PeriodicTask{
    private volatile long tot = 0;
    public PeriodicTask(Runnable r , long millis){
        new Thread(()->{
            long a = 0;
            while( ! Thread.currentThread().isInterrupted()){
                a = System.currentTimeMillis();
                new Thread(r).start();
                a = System.currentTimeMillis() - a;
                tot = tot + a;
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();
    }

    public long getTotalTime(){
        return tot;
    }
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
            System.out.println("Ciao!");
            }
            };
            new PeriodicTask(r, 2000);
            
    }
}