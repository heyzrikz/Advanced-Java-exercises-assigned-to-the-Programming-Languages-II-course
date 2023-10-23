import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PostOfficeQueue{

    private List<Integer> sportelli;
    private final Object mutex = new Object();

    public PostOfficeQueue(int n){
        sportelli = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++){
            sportelli.add(i);
        }
    }

    public int getFreeDesk() throws InterruptedException{
        AtomicInteger ret = new AtomicInteger(0);
        
        Thread th = new Thread(new Runnable(){
            public void run(){
                synchronized(mutex){
                    while(sportelli.isEmpty()){
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    ret.set(sportelli.get(0));
                }
           
        }});
        th.start();
        th.join();
        return ret.get();
    }
    

    public void deskStart(Integer desk){
        synchronized(mutex){
        
                    sportelli.remove(desk);
                
    }
    }

    public void deskFinish(int desk){
        
                synchronized(mutex){
                    sportelli.add(desk);
                    mutex.notifyAll();
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
        System.out.println(poq.getFreeDesk());
    }
}