import java.util.HashMap;
import java.util.Map;

class StringQuiz{
    private String secret;
    private volatile boolean finito;
    private Map<Thread,Integer> threads;
    private final Object mutex = new Object();
    
    public StringQuiz(String secret , int timeout){
        this.secret = secret;
        this.finito = false;
        threads = new HashMap<Thread,Integer>();
        new Thread(new Runnable(){
            public void run(){
                try{

                    Thread.sleep(timeout * 1000);
                    finito = true;
                }catch(InterruptedException i){
                    return;
                }
            }
        }).start();
    }


    public boolean guess(String answer){
        if(finito == true) throw new RuntimeException("Gioco finito");
        synchronized(mutex){
        if(threads.get(Thread.currentThread()) == null) threads.put(Thread.currentThread(),1);
        else if(threads.get(Thread.currentThread()) > 2) throw new RuntimeException("Troppe risposte");
        else threads.put(Thread.currentThread(),threads.get(Thread.currentThread()) + 1);
        }
        return answer == secret;
    }

}

class Main{
    public static void main(String arg[]){
        StringQuiz q = new StringQuiz("ghali",5);
        new Thread(new Runnable(){
            public void run(){
                System.out.println(Thread.currentThread().getName()+" salmo "+q.guess("salmo"));
                System.out.println(Thread.currentThread().getName()+" izi "+q.guess("izi"));
                System.out.println(Thread.currentThread().getName()+" ghali "+q.guess("ghali"));
                
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){
                System.out.println(Thread.currentThread().getName()+" salmo "+q.guess("salmo"));
                System.out.println(Thread.currentThread().getName()+" izi "+q.guess("izi"));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" ghali "+q.guess("ghali"));
                
            }
        }).start();
    }
}