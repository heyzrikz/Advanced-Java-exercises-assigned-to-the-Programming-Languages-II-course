import java.util.HashMap;
import java.util.Map;

public class StringQuiz{
    private Map<Thread,Integer> threads;
    private String segreto;
    private boolean gioco_finito;
    StringQuiz(String segreto , int timeout){
        threads = new HashMap<Thread,Integer>();
        this.segreto = segreto;
        this.gioco_finito = false;
        new Thread(new Runnable(){
            public void run(){
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                gioco_finito = true;
            }
        }).start();
    }


    public boolean guess(String risposta){
        synchronized(threads){
            if(threads.get(Thread.currentThread()) != null && threads.get(Thread.currentThread()) < 2)
                threads.put(Thread.currentThread(),threads.get(Thread.currentThread()) + 1);
            else if(threads.get(Thread.currentThread()) == null)
                threads.put(Thread.currentThread(),0);
                else throw new RuntimeException("Hai finito i tentativi");
            
            if(gioco_finito == false){
                if(risposta.equals(segreto)) return true;
            }else throw new RuntimeException("gioco finito");
                return false;
                
        }
    }
}
class Main{
public static void main(String[] args) {
        StringQuiz q = new StringQuiz("ghali",5000);
        new Thread(new Runnable(){
            public void run(){
                System.out.println(q.guess("salmo"));
                System.out.println(q.guess("izi"));
                System.out.println(q.guess("ghali"));
                
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){
                System.out.println(q.guess("salmo"));
                System.out.println(q.guess("izi"));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(q.guess("ghali"));
                
            }
        }).start();
    }
}