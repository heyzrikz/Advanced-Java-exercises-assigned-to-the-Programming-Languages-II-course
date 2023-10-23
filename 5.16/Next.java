import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
a)non è funzionale per Comparator<?>
b)non è completo poichè non è detto che Set e T devono essere della stess classe
c)non è funzionale per Comparator
d)non è completo poichè non è detto che Set e T devono essere della stess classe
e)non è funzionale poichè Comparator<T> non accetta Object 

*/

public class Next{
static <T> T findNext(Set<? extends T> set, Comparator<? super T> comp, T x ){
    ArrayList<? extends T> al = new ArrayList<>(set);
    al.sort(comp);
    for(T t: al ){
        if(comp.compare(t, x) > 0) return t;
    }
    return null;
}

public static void main(String arg[]){
    Set<Integer> set = new HashSet<>();
    Comparator<Number> comp = new Comparator<Number>(){
        public int compare(Number x ,Number y){
            if(x.doubleValue() > y.doubleValue()) return 1;
            if(x.doubleValue() < y.doubleValue()) return -1;
            return 0;
        }
    };
    set.add(2);
    set.add(5);
    set.add(6);
    System.out.println(Next.findNext(set,comp,new Integer(3)));
}
}