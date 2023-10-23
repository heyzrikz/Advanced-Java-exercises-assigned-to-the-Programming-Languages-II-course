import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Concurrent{
    public static int concurrentMax(int[][] arr) throws InterruptedException{
        AtomicInteger global_max = new AtomicInteger(0);
        BlockingQueue<int[]> queue = new ArrayBlockingQueue<>(arr.length);        
        for(int i = 0 ; i < arr.length; i++){
            queue.put(arr[i]);
        }

        for(int i = 0 ; i < arr.length; i++ ){
            new Thread(){
                public void run(){
                    synchronized(global_max){
                    int[] list;
                    try {
                        list = queue.take();
                        int max = 0;
                    for(Integer index: list){
                        if(index > max) max = index;
                    }
                    if(max >= global_max.get()) global_max.set(max);
                    global_max.notifyAll();
                    } catch (InterruptedException e) {
                        return;
                    }
                    
                }
            }
            }.start();
        }
        synchronized(global_max){
            while(! queue.isEmpty()){
                global_max.wait();
            }
            return global_max.get();
    }
     
}


public static void main(String[] args) throws InterruptedException {
    int [][] arr = { {23, 23, 45, 2, 4},
    {-10, 323, 33, 445, 4},
    {12, 44, 90, 232, 122} };
    System.out.println(concurrentMax(arr)); 
}

}
