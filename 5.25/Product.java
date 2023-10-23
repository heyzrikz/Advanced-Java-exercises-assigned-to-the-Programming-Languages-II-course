import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

/*
a) è funzionale, completa, corretta, offre garanzie massime, semplicità massima, tipo di ritorno non specifico
b)Funzionale, Completa, Corretta, Non offre garanzie, poco semplice, tipo di ritono specifico
c)non completa poichè accetta solo Set di Object

*/

public class Product{
    public static <S,T> Set<Pair<S,T>> product(Set<? extends S> a , Set<? extends T> b){
        Set<Pair<S,T>> set = new HashSet<>();
        for(S s: a){
            for(T t:b){
                set.add(new Pair<S,T>(s,t));
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<String> b = new HashSet<>();
        a.add(1);a.add(2);a.add(3);
        b.add("uno");b.add("due");
        Set<Pair<Number,Object>> ret = product(a, b);
        System.out.println(ret);

    }

}