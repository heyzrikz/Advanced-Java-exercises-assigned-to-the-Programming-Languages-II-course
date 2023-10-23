import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
a)non è completa poichè accetta solo map e collection che hanno chiavi dello stesso tipo K
b)è funzionale, completa, corretta, fornisce garanzie che la Collection non venga modificata, poco semplice ha 2 parametri, il tipo di ritorno conserva l'informazione di tipo presente nei parametri formali
c)è funzionale, non è completa poichè Collection accetta solo tipi super K
d)funzionale, non è completa poichè Collection accetta solo tipi che estendono K
e)non è completa, non accetta qualsiasi Collection bensì sono Set 
f)funzionale, non completa poichè Collection accetta solo chiavi K2 che estendono K
mia soluzione:
*/
class subMap{
public static <K,V> Map<K,V> suMap(Map<? extends K,? extends V> m , Collection<?> c){
    ArrayList<?> a = new ArrayList<>(c);
    Map<K,V> map = new HashMap<>();
    for(K k : m.keySet()){
        if(a.contains(k)) map.put(k,m.get(k));
    }
    return map;
}
public static void main(String arg[]){
    Map<Integer,String> m = new HashMap<>();
    m.put(1,"ciao");
    m.put(2,"bello");
    Collection<Integer> c = new ArrayList<>();
    c.add(1);
    c.add(2);
    Map<Integer,String> ret = subMap.suMap(m, c);
    System.out.println(ret);
}
}