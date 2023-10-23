class MutexWithLog{
    private Thread possessore = null;
    private final Object mutex = new Object();

    public void lock() throws InterruptedException{
       synchronized(mutex){
        while(possessore != null){
            mutex.wait();
        }
        possessore = Thread.currentThread();
        System.out.println(possessore.getName()+" ha acquisito il lock");
       }
    }

    public void unlock(){
        synchronized(mutex){
        if(possessore != Thread.currentThread()) throw new RuntimeException();
        possessore = null;
        System.out.println(Thread.currentThread().getName()+" ha rilasciato il lock");
        mutex.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final MutexWithLog m = new MutexWithLog();
Thread t = new Thread("Secondo") {
public void run() {
try {
    m.lock();
} catch (InterruptedException e) {
    e.printStackTrace();
}
System.out.println("Due!");
m.unlock();
}
};
t. start () ;
m.lock();
System.out.println("Uno!");
m.unlock();
    }

}