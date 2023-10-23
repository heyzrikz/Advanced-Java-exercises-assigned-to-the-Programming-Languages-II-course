import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

interface Selector<T> {
    boolean select(T x);
    }

public class Concurrent{
    public static <T> Set<T> concurrentFilter(Set<? extends T> x , Selector<T> s){
        Set<T> ret = new HashSet<>();
        Object mutex = new Object();
        BlockingQueue<? extends T> queue = new LinkedBlockingQueue<>(x);
        for(int i = 0 ; i < x.size() ; i++){
            new Thread(new Runnable(){
                public void run(){
                    synchronized(mutex){
                    T val;
                    try {
                        val = queue.take();
                    } catch (InterruptedException e) {
                        return;
                    }
                    if(s.select(val)) ret.add(val);
                    mutex.notifyAll();
                }
                }
            }).start();
        }
        
        synchronized(mutex){
            while(! queue.isEmpty()){
                try {
                    mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
}

class Main{
    public static void main(String[] args) {
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