import java.util.ArrayList;
import java.util.Scanner;


public class Esemp {
    public ArrayList<String> a = new ArrayList<>();
    
    public synchronized void aggiungi(){
        System.out.println("Aggiungi:");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
        a.add(input);
    }

    public synchronized void rimuovi(){
        a.remove(a.size() - 1);
    }

    


}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        Esemp e = new Esemp();
        Runnable w = new Runnable() {
            public void run(){
                e.aggiungi();
                
            }
        };

        Runnable r = new Runnable() {
            public void run(){
               e.rimuovi();
            }
        };
           
        Thread th1 = new Thread(w);
        Thread th2 = new Thread(w);
        Thread th3 = new Thread(w);
        Thread th4 = new Thread(r);
        Thread th5 = new Thread(r);
        th1.start();
        th2.start();
        th3.start();
        th3.join();
        th4.start();
        th5.start();
        th5.join();
      
        System.out.println(e.a);

    }
}