import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Program{
    private final Object mutex = new Object();
    private List<Integer> lista = new ArrayList<>();
    private volatile boolean terminato = false;

    public void program(){
        new Thread(()->{
            try {
                add();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                read();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }

    public void add() throws InterruptedException{
        synchronized(mutex){
            Random r = new Random();
            int n = r.nextInt();
            System.out.println(Thread.currentThread().getName()+" numero generato "+n);
            while(n % 100 != 0){
                lista.add(n);
                mutex.notifyAll();
                mutex.wait(100);
                n = r.nextInt();
                System.out.println(Thread.currentThread().getName()+" numero generato "+n);
            }
            terminato = true;
        }
    }

    public void read() throws InterruptedException{
        synchronized(mutex){
            int tot = 0;
            while(terminato == false){
                tot = 0;
                for(int i = 0 ; i < lista.size(); i++){
                    tot = tot + lista.get(i);
                }
                System.out.println(tot);
                mutex.notifyAll();
                mutex.wait(1000);
                mutex.wait();
                
            }
                tot = 0;
                for(int i = 0 ; i < lista.size(); i++){
                    tot = tot + lista.get(i);
                }
                System.out.println(tot);
        }
    }
}

class UseCase{
    public static void main(String arg[]){
        Program t = new Program();
        new Thread(()->{
            try {
                t.add();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                t.read();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }
}

//fai esercizio dove genera un thread per ogni indice di una lista di interi e fa +1 ad ogni elemento 