import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String arg[]) throws InterruptedException{
        Collection<Integer> s = new HashSet<Integer>();
        s.add(3); s.add(13); s.add(88);
        RunnableWithArg<Integer> ru = new RunnableWithArg<Integer>() {
            public void run(Integer i) {
           System.out.println(i/2);
            }
           };
           Thread t = new RunOnSet<Integer>(ru, s);
           t.start();
           t.join();
           
        Esempio e = new Esempio();
        Esempio f = new Esempio();
        e.start();
        e.join();
        Interruptor i = new Interruptor(f, 3);
        i.start();
        i.join();
        Runnable r = new Runnable() {
            public void run() {
            System.out.println("Ciao");
            }
            };
            Esempio.periodicJob(r, 2000);
    }
}
