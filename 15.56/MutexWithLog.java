public class MutexWithLog{
    Thread mutex = null;
    public void lock(){
        synchronized(this){
        while(mutex != null){
            try{
                this.wait();
            }catch(InterruptedException i){return;}
        }
            mutex = Thread.currentThread();
            System.out.println(mutex.getName()+" ha acquisito il lock");
        }
    }

    public void unlock(){
        synchronized(this){
            if(mutex != Thread.currentThread()) throw new RuntimeException();
            System.out.println(mutex.getName()+" ha rilasciato il lock");            
            mutex = null;
            this.notify();
        }
    }
}

class Main{
    public static void main(String[] args) {
        final MutexWithLog m = new MutexWithLog();
Thread t = new Thread("Secondo") {
public void run() {
m.lock();
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