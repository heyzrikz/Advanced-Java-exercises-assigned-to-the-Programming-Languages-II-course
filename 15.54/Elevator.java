import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Elevator{
    private int floors;
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    public Elevator(int floors){
        this.floors = floors;
        new Thread(new Runnable(){
            public void run(){
                int current_floor = 0;
                int destination = 0;
                while(! Thread.currentThread().isInterrupted()){
                    try{
                        destination = queue.take();
                        System.out.println("Elevator leaves floor "+current_floor);
                        if(current_floor < destination){
                            while(current_floor < destination ){
                                Thread.sleep(2000);
                                current_floor++;
                            }
                        }else{
                            while(current_floor > destination ){
                                Thread.sleep(2000);
                                current_floor--;
                            }
                        }
                        System.out.println("Elevator stops at floor "+current_floor);
                    }catch(InterruptedException i){
                        return;
                    }
                }
            }
        }).start();
    }

    public void call(int floor) throws InterruptedException{
        if(floor > floors || floor < 0) throw new RuntimeException();
        queue.put(floor);
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        Elevator e = new Elevator(10);
        e. call (8);
        e. call (5);
        e. call (3);
        e. call (4);

    }
}