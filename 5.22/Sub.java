import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
a)funzionale, completa, corretta, offre garanzie sul valore della mappa, semplice, tipo di ritorno non specifico
b)funzionale, completa, corretta, offre garanzie sulla collection, semplice, tipo di ritorno specifico
c)funzionale, completa, corretta, offre garanzie sulla collection, semplice, tipo di ritorno specifico
d)funzionale, completa, corretta, offre garanzie sulla collection, semplice, tipo di ritorno specifico
e)funzionale, non completa poichè non accetta altre collection al di fuori di Set
f)funzionale, completa, corretta, offre garanzie sulla collection, non è semplice, tipo di ritorno specifico

mia soluzione:
*/

class Sub{
    public static <K,V> Map<K,V> subMap(Map<? extends K,? extends V> m , Collection<?> c){
        Map<K,V> ret = new HashMap<>();
        for(K k : m.keySet()){
            if(! c.contains(k)) ret.put(k,m.get(k));
        }
        return ret;
    } 

    public static void main(String[] args) {
        Map<Integer,String> m = new HashMap<>();
        m.put(0, "zero");
        m.put(1, "uno");
        Collection<String> c = new ArrayList<>();
        c.add("1");
        c.add("3");
        Map<Number,Object> ret = subMap(m, c);
        System.out.println(ret);

    }
}