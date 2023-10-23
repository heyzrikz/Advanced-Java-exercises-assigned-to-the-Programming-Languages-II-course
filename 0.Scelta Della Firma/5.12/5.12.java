import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

/*
a) funzionale, completa, corretta, non offre ulteriori garanzie, semplicità: 2 tipi parametrici, tipo di ritorno molto specifico
b) non è funzionale poichè in questo caso dovrebbe accettare solo Pair<Object,Object>
c) non completa poichè accetta solo Set di Object
d) non funzionale poichè non posso fare .add() sul Set di ritorno
e) non completa poichè accetta solo Set dello stesso tipo S
f) non completa poichè accetta solo Set di S che estende diretamente T
*/
class CartesianProduct{
public static <S,T> Set<Pair<S,T>> cartesianProduct(Set<? extends S> a , Set<? extends T> b){
    Set<Pair<S,T>> ret = new HashSet<>();
    for(S s: a){
        for(T t:b){
            ret.add(new Pair<S,T>(s,t));
        }
    }
    return ret;
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
    set = cartesianProduct(s, t);
    System.out.println(set);
}
}