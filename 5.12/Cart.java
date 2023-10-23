import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

/*
a)funzionale, completa , corretta, poco semplice, non fornisce ulteriori garanzie, il tipo di ritorno è specifico 
b)non è funzionale non posso assegnare ? a S o ? a T
c)non è funzionale non posso assegnare Object a ?
d)non corretto, il tipo di ritorno deve essere un Set di Pair
e)non completo, non devono essere necessariamente dello stesso tipo i valori
f)non è completo, S e T non devono essere per forza nella stessa gerarchia di tipi

*/
public class Cart {
    static <S,T> Set<Pair<S,T>> cartesianProduct(Set<? extends S> s, Set<? extends T> t){
        Set<Pair<S,T>> set = new HashSet<>();
        for(S ss : s){
            for(T tt: t){
                set.add(new Pair<S,T>(ss,tt));
            }
        }
        return set;
    }
    public static void main(String arg[]){
        Set<Number> s = new HashSet<>();
        Set<String> t = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        t.add("a");
        t.add("b");
        Set<Pair<Object,Object>> set;
        set = Cart.cartesianProduct(s, t);
        System.out.println(set);
    }

}
