import java.util.HashSet;
import java.util.Set;

public class Concurrent extends Thread{
    public static <T> Set<T> concurrentFilter(Set<? extends T> x , Predicate<? super T> p) throws InterruptedException{
        Set<T> y = new HashSet<>();
        for(T t : x){
           Thread th = new Thread(){
               public void run(){
                   synchronized(y){
                if(p.test(t)) y.add(t);
                   }
               }
            };
            th.start();
            th.join();
        }
        return y;
    }

    public static void main(String arg[]) throws InterruptedException{
        Set<Integer> x = new HashSet<Integer>();
    x.add(1); x.add(2); x.add(5);
    Predicate<Integer> isOdd = new Predicate<Integer>() {
    public boolean test(Integer n) {
        return (n%2 != 0);
         }
        };

        Set<Integer> y = concurrentFilter(x, isOdd);
    for (Integer n: y)
        System.out.println(n);
    }


}