import java.util.HashMap;
import java.util.Map;

public class GuessTheNumber{
    private static int number;
    private static long durata;
    private static Map<GuessTheNumber,Integer> partecipanti;
    private static boolean terminato;
    private boolean vincitore;

    GuessTheNumber(){
        vincitore = false;
    }

    GuessTheNumber(int n,long d) throws InterruptedException{
        number = n;
        durata = d;
        partecipanti = new HashMap<GuessTheNumber,Integer>();
        terminato = false;
        vincitore = false;
        Runnable r = new Runnable(){
            public void run(){   
                synchronized(partecipanti){
                    System.out.println(Thread.currentThread().getName()+": prende monitor");
                int differenza = 10000000;
                GuessTheNumber guess = null;
                for(GuessTheNumber g:partecipanti.keySet()){
                    if(partecipanti.get(g) <= differenza){
                        if(partecipanti.get(g) != differenza && guess != null) guess.vincitore=false;
                        differenza = partecipanti.get(g);
                        guess = g;
                        guess.vincitore = true;
                        
                    }
                }
                terminato = true;
                System.out.println(Thread.currentThread().getName()+": notifica tutti");
                partecipanti.notifyAll();
            }
            }
        };
        Thread.sleep(durata);
        new Thread(r).start();
    }

    public boolean guessAndWait(int soluzione) throws InterruptedException{
        if(terminato == true) throw new RuntimeException("Quiz terminato");
        synchronized(partecipanti){
            System.out.println(Thread.currentThread().getName()+": prende monitor");
        int differenza = number - soluzione;
        if(differenza < 0) differenza = differenza * (-1);
        partecipanti.put(this,differenza);
        while(terminato == false){
            System.out.println(Thread.currentThread().getName()+": aspetta");
            partecipanti.wait();
            System.out.println(Thread.currentThread().getName()+": si sveglia");
    }
        }
     return vincitore;
             }


                }

class Main{
    public static void main(String arg[]) throws InterruptedException{
        

        Thread th0 = new Thread(new Runnable() {
            public void run(){
                try {
                    GuessTheNumber g = new GuessTheNumber(5,10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread th1 = new Thread(new Runnable() {
            public void run(){
                GuessTheNumber p1 = new GuessTheNumber();
                try {
                    System.out.println("p1 vince: "+p1.guessAndWait(7));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
       
        Thread th2 = new Thread(new Runnable() {
            public void run(){
                GuessTheNumber p2 = new GuessTheNumber();
                try {
                    System.out.println("p2 vince: "+p2.guessAndWait(3));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread th3 = new Thread(new Runnable() {
            public void run(){
                GuessTheNumber p2 = new GuessTheNumber();
                try {
                    Thread.sleep(15000);
                    System.out.println("p3 vince: "+p2.guessAndWait(3));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        th0.start();
        th1.start();
        th2.start();
        th3.start();

    }


}