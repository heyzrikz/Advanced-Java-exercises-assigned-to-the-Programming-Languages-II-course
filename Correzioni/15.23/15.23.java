import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class Merge{
    public static <T> List<T> mergeIfSorted(List<? extends T> a , List<? extends T> b , Comparator<? super T> c) throws InterruptedException{
        AtomicBoolean check = new AtomicBoolean(true);
        Thread ta = new Thread(()->{
            T prec = null;
            for(T t: a){
                if(prec == null) prec = t;
                if(c.compare(prec,t) > 0){
                    synchronized(check){
                        check.set(false);
                        return;
                    }
                }
            }
            return;
        });

        Thread tb = new Thread(()->{
            T prec = null;
            for(T t: b){
                if(prec == null) prec = t;
                if(c.compare(prec,t) > 0){
                    synchronized(check){
                        check.set(false);
                        return;
                    }
                }
            }
            return;
        });

        ta.start();
        tb.start();
        ta.join();
        tb.join();

        if(check.get() == false) return null;
        List<T> ret = new ArrayList<>();
        ret.addAll(a);
        ret.addAll(b);
        Collections.sort(ret,c);
        return ret;
    }
}

class UseCase{
    public static void main(String arg[]) throws InterruptedException{
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1); a.add(3); a.add(5);
        b.add(2);b.add(4);b.add(6);
        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer i , Integer j){
                if(i < j) return -1;
                if(i > j) return 1;
                return 0;
            }
        };
        System.out.println(Merge.mergeIfSorted(a, b, c));
    }
}