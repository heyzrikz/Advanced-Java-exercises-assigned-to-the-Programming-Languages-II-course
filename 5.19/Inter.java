import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
a)Funzionale , Completa , Corretta , Fornisce Garanzie massime, Semplice, Il tipo di ritorno è troppo generico
b)Funzionale, Non Completa accetta solo List di Object
c)Funzionale , non completa poichè non è detto che gli elementi di List devono essere nella stessa gerarchia degli elementi di Set
e)Funzionale, Completa, Corretta, Fornisce garanzie, Semplicitè, I parametri danno informazioni sul tipo di ritorno corretto


*/
public class Inter{

    static<T> List<T> listIntersection(List<? extends T> l , Set<?> s){
        List<T> ret = new LinkedList<>();
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