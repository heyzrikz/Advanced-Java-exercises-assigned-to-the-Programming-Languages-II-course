import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PostOfficeQueue{
    BlockingQueue<Integer> coda;

    public PostOfficeQueue(int number) throws InterruptedException{
        coda = new ArrayBlockingQueue<Integer>(number);
        for(int i = 0; i < number ; i++){
            coda.put(i);
        }
    }

    public void deskStart(Integer i) throws InterruptedException{
        coda.take();
    }

    public void deskFinish(Integer i) throws InterruptedException{
        synchronized(coda){
        coda.put(i);
            coda.notifyAll();
        }
    }

    public Integer getFreeDesk() throws InterruptedException{
        synchronized(coda){
        while(coda.isEmpty()){
            coda.wait();
            }
            return coda.peek();
        }
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        PostOfficeQueue poq = new PostOfficeQueue(3);
System.out.println(poq.getFreeDesk());
poq.deskStart(0);
System.out.println(poq.getFreeDesk());
poq.deskStart(1);
poq.deskStart(2);
Thread th = new Thread(){
    public void run(){
        try {
            System.out.println(poq.getFreeDesk());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};
th.start();
Thread.sleep(1000);
poq.deskFinish(2);
    }
}