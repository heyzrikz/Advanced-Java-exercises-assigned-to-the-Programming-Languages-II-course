import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

interface Selector<T>{
    boolean select(T x);
}

class Concurrent{
    public static <T> Set<T> concurrentFilter(Set<? extends T> x , Selector<? super T> s) throws InterruptedException{
        //ho usato una coda poichè è già sincronizzata e quindi non necessito di ulteriori synchronized
        BlockingQueue<T> queue = new LinkedBlockingQueue<>(x);
        Set<T> ret = new HashSet<>();
        //ho usato questo check per poter mettere in attesa il main-thread se non sono ancora stati processati tutti i dati presenti nel set
        AtomicInteger check = new AtomicInteger(x.size());
            int i = x.size();
            while(i > 0){
                new Thread(()->{
                    try{
                    T val = queue.take();
                    if(s.select(val) == true) ret.add(val);
                    synchronized(check){
                        check.decrementAndGet();
                        check.notifyAll();
                    }
                    }catch(InterruptedException e){
                        return;
                    }
                }).start();
                i--;
            }
            synchronized(check){
            while(check.get() > 0) 
                check.wait();
            }
        
        return ret;
        
    }

    public static void main(String[] args) throws InterruptedException {
        Set<Integer> x = new HashSet<Integer>();
x.add(1); x.add(2); x.add(5);
Selector<Integer> oddSelector = new Selector<Integer>() {
public boolean select(Integer n) {
return (n%2 != 0);
}
};
Set<Integer> y = concurrentFilter(x, oddSelector);
for (Integer n: y)
System.out.println(n);
    }
 }