import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public class Merge{
    public static <T> List<T> mergeIfSorted(List<? extends T> a , List<? extends T> b , Comparator<? super T> c){
        AtomicBoolean d = new AtomicBoolean(true);
        Thread th1 = new Thread(new Runnable(){
            public void run(){
            T base = a.get(0);
            for(T t : a){
                if(c.compare(base,t) > 0) d.set(false);
                else base = t;
            }
        }
        });

        Thread th2 = new Thread(new Runnable(){
            public void run(){
            T base = b.get(0);
            for(T t : b){
                if(c.compare(base,t) > 0) d.set(false);
                else base = t;
            }
        }
        });

        try {
            th1.start();
            th2.start();
            th1.join();
            th2.join();
            if(d.get() == false) return null;
            List<T> ret = new ArrayList<>();
            int i = 0 , j = 0;
            while(i < a.size() && j < b.size()){
                if(c.compare(a.get(i),b.get(j)) >= 0){
                     ret.add(b.get(j));
                     j++;
                    }else{
                        ret.add(a.get(i));
                        i++;  
                    }
                }

                while(i < a.size()){
                    ret.add(a.get(i));
                        i++; 
                }

                while(j < b.size()){
                    ret.add(b.get(j));
                        j++; 
                }
                return ret;
        } catch (InterruptedException e) {
            return null;
            //TODO: handle exception
        }
        
    }
}

class Main{
    public static void main(String arg[]){
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