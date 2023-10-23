import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Concurrent{
    public static <T> Set<T> concurrentFilter(Set<? extends T> x , Selector<? super T> oddSelector) throws InterruptedException{
        BlockingQueue<T> queue = new LinkedBlockingQueue<>(x);
        Set<T> ret = new TreeSet<>(); 
        for(int i = 0 ; i < x.size() ; i++){
            new Thread(){
                public void run(){
                    T val;
                    try {
                        val = queue.take();
                        if(oddSelector.select(val)) ret.add(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    synchronized(queue){
                        queue.notifyAll();
                    }
                }
            }.start();
        }

        synchronized(queue){
            while(! queue.isEmpty()){
                queue.wait();
            }
        }
        return ret;
}
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        Set<Integer> x = new HashSet<Integer>();
        x.add(1); x.add(2); x.add(5);
        Selector<Integer> oddSelector = new Selector<Integer>() {
        public boolean select(Integer n) {
        return (n%2 != 0);
        }
        };
        Set<Integer> y = Concurrent.concurrentFilter(x, oddSelector);
        for (Integer n: y)
        System.out.println(n);
          
    }
}