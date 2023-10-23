import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
il metodo accetta due collezioni di tipo arbitrario e rimuove, se presenti, da entrambe tutti gli oggetti che hanno in comune

a)funzionale, non completa poichè accetta solo collezioni dello stesso tipo S
b)funzionale, completa, corretta, offre garanzie su entrambe le collezioni, semplicità: 1, tipo di ritorno specifico
c)funzionale, completa, corretta, non offre garanzie, semplicità: 2, tipo di ritorno poco specifico poichè è possibile scorrere il Set solo con Object
d)funzionale, non completa poichè accetta solo Liste
e)non funzionale poichè al set di ritorno possiamo aggiungere solo Object ma accetta solo tipi S

*/


class Dis{
public static <S> Set<S> disjoin(Collection<? extends S> a , Collection<?> b){
    Set<S> ret = new HashSet<>();
    Collection<? extends S> tmp = new LinkedList<>(a);
    for(S s: tmp){
        if(b.contains(s)){
            b.remove(s);
            a.remove(s);
            ret.add(s);
        }
    }
    return ret;
} 
public static void main(String arg[]){
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Object> b = new ArrayList<>();
    a.add(1);
    a.add(2);
    b.add(2);
    b.add("2");
    Set<Number> set = disjoin(a, b);
    System.out.println(set);
}
}

