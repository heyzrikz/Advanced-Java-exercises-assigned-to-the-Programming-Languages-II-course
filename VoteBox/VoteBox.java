import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VoteBox{
    private static int numero_votanti;
    private static Map<Boolean,Integer> voti;
    private static Set<Thread> threads;

    VoteBox(int n){
        threads = new HashSet<Thread>();
        synchronized(threads){
        numero_votanti = n;
        voti = new HashMap<Boolean,Integer>();
        voti.put(true,0);
        voti.put(false,0);
        }
    }

    public void vote(boolean vote){
        synchronized(threads){
            if(numero_votanti > 0){
                    if(threads.contains(Thread.currentThread())) throw new RuntimeException("Questo thread ha già votato");
                voti.put(vote,voti.get(vote) + 1);
                threads.add(Thread.currentThread());
                numero_votanti--;
                threads.notifyAll();
            }else throw new RuntimeException("Votazione conclusa");
        }

    }

    public boolean isDone(){
        synchronized(threads){
            if(numero_votanti == 0) return true;
            else return false;
        }
    }

    public boolean waitForResult() throws InterruptedException{
        synchronized(threads){
            while(! isDone()){
                threads.wait();
            }
            return voti.get(true) > voti.get(false);
        }
        
    }

}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        VoteBox b = new VoteBox(2);
        b.vote(true);
        
        new Thread(new Runnable() {
            public void run(){
                try {
                    System.out.println(b.waitForResult());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }            }
        }).start();

        new Thread(new Runnable() {
            public void run(){
                b.vote(false);
            }
        }).start();

        new Thread(new Runnable() {
            public void run(){
                b.vote(true);
            }
        }).start();

        new Thread(new Runnable() {
            public void run(){
                b.vote(true);
            }
        }).start();
    }

    
}