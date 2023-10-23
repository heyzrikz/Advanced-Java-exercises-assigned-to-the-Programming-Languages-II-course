import java.util.HashSet;
import java.util.Set;

class VoteBox{
    private int num;
    private final Object mutex = new Object();
    private Set<Thread> threads = new HashSet<>();
    private int voto_true = 0;
    private int voto_false = 0;

    public VoteBox(int num){
        this.num = num;
    }

    public void vote(boolean vote){
        synchronized(mutex){
            if(threads.size() < num){
            if(threads.contains(Thread.currentThread())) throw new RuntimeException();
            threads.add(Thread.currentThread());
            if(vote == true) voto_true++;
            else voto_false++;
            mutex.notifyAll();
            }else throw new RuntimeException("votazione terminata");
        }
    }

    public boolean waitForResults() throws InterruptedException{
        synchronized(mutex){
            while(threads.size() < num){
                mutex.wait();
            }
        }
        if(voto_true > voto_false) return true;
        else return false;
    }

    public boolean isDone(){
        synchronized(mutex){
            return threads.size() >= num;
        }
    }

    public static void main(String arg[]) throws InterruptedException{
        VoteBox b = new VoteBox(2);
        b.vote(true);
        
        new Thread(new Runnable() {
            public void run(){
                try {
                    System.out.println(b.waitForResults());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }            }
        }).start();

        new Thread(new Runnable() {
            public void run(){
                b.vote(true);
            }
        }).start();

        new Thread(new Runnable() {
            public void run(){
                //b.vote(true);
            }
        }).start();

        new Thread(new Runnable() {
            public void run(){
               // b.vote(true);
            }
        }).start();
    }

}