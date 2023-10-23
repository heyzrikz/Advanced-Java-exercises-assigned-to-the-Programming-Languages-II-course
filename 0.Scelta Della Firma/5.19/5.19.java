import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
ho interpretato la traccia come se il Set può accettare qualsiasi tipo

a) non è funzionale poichè non è possibile aggiungere elementi alla lista di ritorno
b) non è completa poichè accetta solo List<Object>
c) funzionale, non completa poichè accetta solo Set con elementi di un tipo assegnabile a T
d) funzionale, completa, corretta, offre garanzie massime sul set, semplicità: 1, tipo di ritorno specifico
e) funzionale, completa, corretta, non offre ulteriori garanzie, semplicità: 2, tipo di ritorno specifico

*/

class Intersection{
    public static <T> List<T> listIntersection(List<? extends T> l , Set<?> s){
        List<T> ret = new ArrayList<>();
        for(T t : l){
            if(s.contains(t)) ret.add(t);
        }
        return ret;
    }

    public static void main(String arg[]){
        List<Integer> l = new LinkedList<>();
        l.add(2); l.add(1); l.add(3);
        l.add(4); l.add(5); l.add(6);
    
        Set<Object> s = new HashSet<>();
        s.add(3);
        s.add(new Object());
        s.add(1);
    
        List<Integer> ret = listIntersection(l,s);
        System.out.println(ret);
    }
}