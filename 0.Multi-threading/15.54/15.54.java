import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Elevator{
    private volatile int piano = 0;
    private final int n_piani;
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

    public Elevator(int n_piani){
        this.n_piani = n_piani;
        new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                Integer next_piano;
                try {
                    next_piano = queue.take();
                } catch (InterruptedException e) {
                    return;
                    }
                    System.out.println("Elevator leaves floor "+piano);
                while(piano < next_piano){
                    
                    try{
                    Thread.sleep(2000);
                    }catch(InterruptedException i){
                        return;
                    }
                    piano++;
                   
                }

                while(piano > next_piano){
                    try{
                    Thread.sleep(2000);
                    }catch(InterruptedException i){
                        return;
                    }
                    piano--;                   
                }
                System.out.println("Elevator stops floor "+piano);
            }
        }).start();
    }

public void call(int p) throws InterruptedException{
    if(p < 0 || p > n_piani) throw new RuntimeException();
    queue.put(p);
}

public static void main(String[] args) throws InterruptedException {
    Elevator e = new Elevator(10);
e. call (8);
e. call (5);
e. call (3);
e. call (4);
}

}