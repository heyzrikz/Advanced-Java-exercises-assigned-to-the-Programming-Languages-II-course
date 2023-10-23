import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Merge{
    public static <T> List<T> mergeIfSorted(List<? extends T> a , List<? extends T> b , Comparator<? super T> c) throws InterruptedException{
        AtomicInteger error = new AtomicInteger(0);
        final Object mutex = new Object();
        Thread tha = new Thread(()->{
            T prec = a.get(0);
            for(T t : a){
                if(c.compare(prec,t) > 0){
                    synchronized(mutex){
                    error.set(1);
                    }
                    break;
                }
                prec = t;
            }
        });

         Thread thb = new Thread(()->{
            T prec = b.get(0);
            for(T t : b){
                if(c.compare(prec,t) > 0){
                    synchronized(mutex){
                    error.set(1);
                    }
                    break;
                }
                prec = t;
            }
        });
        tha.start();
        thb.start();
        tha.join();
        thb.join();
        if(error.get() != 0) return null;
        int i = 0;
        int j = 0;
        List<T> ret = new LinkedList<>();
        while(i < a.size() && j < b.size()){
            if(c.compare(a.get(i),b.get(j)) < 0){
                ret.add(a.get(i));
                i++;
                }else{
                    ret.add(b.get(j));
                    j++;
                }
        }

            while(i < a.size() ){
                ret.add(a.get(i));
                i++;
            }

            while(j < b.size() ){
                ret.add(b.get(j));
                j++;
            }
            return ret;
    }

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