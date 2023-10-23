import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TwoThreads{
List<Integer> lista = new LinkedList<>();
public void program(){
    Random rand = new Random();

    Thread th2 = new Thread(new Runnable(){
        public void run(){
            int sum = 0;
            while(true){
                try {
            synchronized(lista){
                for(Integer i : lista){
                    sum = sum + i;
                }
                lista.clear();

            
            System.out.println(sum);
            
                Thread.sleep(1000);
                lista.wait();
            }
            } catch (InterruptedException e) {
                return;
            }
            
        }
    }
    });

    Thread th1 = new Thread(new Runnable(){
        public void run(){
            int number = 123;
            while(number % 100 != 0){
                number = rand.nextInt();
            synchronized(lista){
                try {
                lista.add(number);
                lista.notifyAll();
                
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Termino programma numero generato: "+number);
        th2.interrupt();
    }
    });
    th1.start();
    th2.start();

    


}
}

class Main{
    public static void main(String arg[]){
        TwoThreads t = new TwoThreads();
        t.program();
    }
}