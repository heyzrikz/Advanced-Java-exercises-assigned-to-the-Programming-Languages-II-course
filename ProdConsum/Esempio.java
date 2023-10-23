public class Esempio{
    int a[] = new int[5];
    private int size = 0;
    public synchronized void aggiungi(int val) throws InterruptedException{
        System.out.println("entro in aggiungi");
        while(size >= 5){
            System.out.println("aspetto per aggiungere");
            wait();}
        
            System.out.println("aggiungo");
            a[size] = val;
            size++;
            notifyAll();
        
    }

    public synchronized void rimuovi() throws InterruptedException{
        System.out.println(Thread.currentThread().getId()+" entro in rimuovi");
        while(size == 0) {
            System.out.println(Thread.currentThread().getId()+" aspetto per rimuovere");
            wait();}
        
            System.out.println(Thread.currentThread().getId()+" rimuovo");
            size--;
            if(size < 0) throw new RuntimeException("Size < 0");
            notifyAll();
        
    }
}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        Esempio e =  new Esempio();
        Runnable w = new Runnable() {
            public void run(){
                try {
                    e.aggiungi(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        };

        Runnable r = new Runnable() {
            public void run(){
               try {
                e.rimuovi();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
        };


        
        Thread prod1 = new Thread(w);
        Thread cons1 = new Thread(r);
        Thread cons2 = new Thread(r);
        Thread prod2 = new Thread(w);
        cons1.start();
        cons2.start();
        Thread.sleep(2000);
        prod1.start();
        prod2.start();


    }
    

}