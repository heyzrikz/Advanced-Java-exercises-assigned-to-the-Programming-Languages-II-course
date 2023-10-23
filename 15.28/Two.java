import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Two{
    //pongo che i1 e i2 abbiano la stessa dimensione per semplicità
    public static void twoPhased(List<Runnable> i1 , List<Runnable> i2){
        AtomicReference<Thread> inEsecuzione = new AtomicReference<>();
        Thread verifica = new Thread(new Runnable(){
            public void run(){
                synchronized(i1){
                    System.out.println(Thread.currentThread().getName()+": prendo monitor");
                    while(! Thread.currentThread().isInterrupted()){
                        if(inEsecuzione.get() != null && !inEsecuzione.get().isAlive()){
                            inEsecuzione.set(null);
                            System.out.println(Thread.currentThread().getName()+": notifico");
                            i1.notifyAll();
                           }
                           while(inEsecuzione.get() == null){
                            try{System.out.println(Thread.currentThread().getName()+": dormo");i1.wait(); System.out.println(Thread.currentThread().getName()+": mi sveglio");}catch(InterruptedException i){return;}
                        }
                    }
                }
            }
        });

        verifica.start();

        new Thread(new Runnable(){
            public void run(){
                synchronized(i1){
                    System.out.println(Thread.currentThread().getName()+": prendo monitor");
                    Thread th;
                while(i1.iterator().hasNext() && i2.iterator().hasNext()){
                    th = new Thread(i1.iterator().next());
                    inEsecuzione.set(th);
                    th.start();
                    System.out.println(Thread.currentThread().getName()+": notifico");
                    i1.notifyAll();
                    while(inEsecuzione.get() != null)
                        try {
                            System.out.println(Thread.currentThread().getName()+": aspetto");
                            i1.wait();
                            System.out.println(Thread.currentThread().getName()+": mi sveglio");
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            return;
                        }
                    th = new Thread(i2.iterator().next());
                    inEsecuzione.set(th);
                    th.start();
                    System.out.println(Thread.currentThread().getName()+": notifico");
                    i1.notifyAll();
                    while(inEsecuzione.get() != null)
                        try {
                            System.out.println(Thread.currentThread().getName()+": aspetto");
                            i1.wait();
                            System.out.println(Thread.currentThread().getName()+": mi sveglio");
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            return;
                        }
                }
                verifica.interrupt();
            }
        }
        }).start();

        


    }
}

class Main{
    public static void main(String arg[]){
        ArrayList<Runnable> a = new ArrayList<>();
        ArrayList<Runnable> b = new ArrayList<>();
        Runnable r1 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run1 terminato");
            }
        };
        Runnable r2 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run2 terminato");
            }
        };
        Runnable r3 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run3 terminato");
            }
        };
        Runnable r4 = new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run4 terminato");
            }
        };

        a.add(r1);
        b.add(r2);
        a.add(r3);
        b.add(r4);

        Two.twoPhased(a, b);
        
    }
}