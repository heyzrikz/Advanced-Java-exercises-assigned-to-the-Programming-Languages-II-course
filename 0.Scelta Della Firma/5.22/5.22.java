import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
considero che la Collezione non deve contenere necessariamente elementi dello stesso tipo delle chiavi della mappa
a) funzionale, non completa poichè accetta solo Collection dello stesso tipo delle chiavi della mappa K
b) funzionale, completa, corretta, offre garanzie massime sulla collezione, semplicità: 2, tipo di ritorno molto specifico
c) funzionale, non completa poichè accetta SOLO Collection di tipo superiori a K
e) funzionale, non completa poichè accetta SOLO Set
f) funzionale, non completa poichè accetta SOLO Collection di tipo che estende direttamente K

*/

class Sub{
    public static <K,V> Map<K,V> subMap(Map<? extends K, ? extends V> m , Collection<?> c){
        Map<K,V> ret = new HashMap<>();
        for(K k: m.keySet()){
            if(c.contains(k)) ret.put(k,m.get(k));
        }
        return ret;
    }

    public static void main(String[] args) {
        Map<Integer,String> m = new HashMap<>();
        m.put(0, "zero");
        m.put(1, "uno");
        Collection<Number> c = new ArrayList<>();
        c.add(1);
        c.add(3);
        Map<Number,Object> ret = subMap(m, c);
        System.out.println(ret);

    }
}