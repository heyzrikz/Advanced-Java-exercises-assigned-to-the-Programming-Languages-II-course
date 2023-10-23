public class Exec{
public static void executeWithDeadline(Runnable r , int t) throws InterruptedException{
    Thread th = new Thread(r);
    th.start();
    Thread.sleep((t * 1000));
    th.interrupt();

}
public static void main(String[] args) throws InterruptedException {
    Exec.executeWithDeadline(new Runnable(){
        public void run(){
            try{
            System.out.println("Start");
            Thread.sleep(5000);
            System.out.println("End");
            }catch(InterruptedException i){
                System.out.println("Interrotto");
                return;
            }
        }
    },10);
}
}