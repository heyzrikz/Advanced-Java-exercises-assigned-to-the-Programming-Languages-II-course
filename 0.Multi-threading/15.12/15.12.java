class SharedCounter{
    private volatile int counter;
    private final Object mutex = new Object();

    public SharedCounter(){
        this.counter = 0;
    }

    public void incr() throws InterruptedException{
        Thread.sleep(100);
        synchronized(mutex){
            counter++;
            mutex.notifyAll();
        }
    }

    public void decr(){
        synchronized(mutex){
        if(counter != 0) counter--;
        mutex.notifyAll();
        }
    }

    public void waitForValue(int val){
        synchronized(mutex){
            while(counter != val){
                try{
                mutex.wait();
                }catch(InterruptedException i){
                    i.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SharedCounter sc = new SharedCounter();
        new Thread(new Runnable() {
            public void run(){
                sc.waitForValue(4);
                System.out.println("Arrivato a 4!");
            }
        }).start();
        sc.incr();
        sc.incr();
        sc.incr();
        sc.incr();
        sc.incr();

    }
}