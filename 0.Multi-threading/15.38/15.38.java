import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;

class PostOfficeQueue{
    private BlockingQueue<Integer> queue;
    private final Object mutex = new Object();

    public PostOfficeQueue(int num) throws InterruptedException{
        queue = new ArrayBlockingQueue<Integer>(num);
        synchronized(mutex){
        for(int i = 0 ; i < num ; i++){
            queue.put(i);
        }
        }
    }

    public Integer getFreeDesk(){
        synchronized(mutex){
            while(queue.isEmpty()){
                try{
                    mutex.wait();
                }catch(InterruptedException i){
                    i.printStackTrace();
                }
            }
            return queue.element();
        }
    }

    public void deskStart() throws InterruptedException{
        synchronized(mutex){
            queue.take();
        }
    }

    public void deskFinish(int i) throws InterruptedException{
        synchronized(mutex){
            queue.put(i);
        }
    }

}

class Main{
   public static void main(String[] args) throws InterruptedException {
    PostOfficeQueue poq = new PostOfficeQueue(5);
    
    //System.out.println(poq.getFreeDesk());
    Function<PostOfficeQueue,Integer> getFreeDeskFunction = PostOfficeQueue::getFreeDesk;
    Consumer<PostOfficeQueue> getFreeDeskConsumer = (p)->System.out.println(getFreeDeskFunction.apply(p));
    getFreeDeskConsumer.accept(poq);
    
    //poq.deskStart();
    Consumer<PostOfficeQueue> deskStartConsumer = (p)->{ try {p.deskStart();} catch (InterruptedException e) {e.printStackTrace();}};
    deskStartConsumer.accept(poq);
    
    //System.out.println(poq.getFreeDesk());
    getFreeDeskConsumer.accept(poq);
    
    //poq.deskStart();
    deskStartConsumer.accept(poq);
    
    //poq.deskStart();
    deskStartConsumer.accept(poq);
    
    //System.out.println(poq.getFreeDesk());
    getFreeDeskConsumer.accept(poq);
   
    } 
}