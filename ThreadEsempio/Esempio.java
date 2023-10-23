public class Esempio extends Thread{
    public void run(){
        System.out.println("Thread n."+this.getId());
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
               return;
            }
        }
            
    }

    public static void periodicJob(Runnable r , int millisecondi) throws InterruptedException{
        while(Thread.currentThread().isInterrupted()==false){
        new Thread(r).start();
        Thread.sleep(millisecondi);
        }
    }
}
