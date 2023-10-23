import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
a)non funzionale, Comparator non è compatibile per il tipo V
b)non funzionale, Comparator non è compatibile per il tipo V
c)funzionale, corretto,completo,non da ulteriori garanzie,non è semplice
d)non completo, non deve accettare necessariamente lo stesso tipo
e)non completo, non deve accettare necessariamente lo stesso tipo
f)completo,corretto,funzionale,semplice,da ulteriori garanzie
g)non funzionale
*/


public class Increasing {
    static<T> boolean isIncreasing(Map<? extends T , ? extends T> m ,Comparator<? super T> c ){
        for(T t : m.keySet()){
            if(c.compare(t, m.get(t)) > 0) return false;
        }
        return true;
    }

    public static void main(String arg[]){
        Map<Integer,Double> m = new HashMap<>();
        Comparator<Number> c = new Comparator<Number>() {
            public int compare(Number x ,Number y){
                if(x.doubleValue() > y.doubleValue()) return 1;
                if(x.doubleValue() < y.doubleValue()) return -1;
                return 0;
            }
           
        };
        m.put(0, 1.5);
        m.put(2,1.3);
        m.put(3, 4.1);
        System.out.println(Increasing.isIncreasing(m, c));
    }
}
