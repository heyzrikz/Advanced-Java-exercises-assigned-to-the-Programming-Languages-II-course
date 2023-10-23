import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
a)non è completo poichè accetta come Mappa solo se ha come valori Object
b)non è completo poichè accetta SOLO mappa con K e V uguali
c)non funzionale, non può accettare un Comparator<?>
d)è completo, è corretto , è funzionale, fornisce garanzir in più come la possibilità di non poter modificare la mappa e poter leggere solo con Object, semplicità della firma, tipo di ritorno poco specifico
e)non è funzionale, posso leggere la mappa solo con Object, ma Set accetta K

mia soluzione:




*/ 

public class KeysWith{
static <K,V> Collection<? super K> keysWithHighestValue(Map<? extends K,? extends V> map , Comparator<? super V> c){
    ArrayList<? super K> a = new ArrayList<>();
    TreeMap<? extends K , ? extends V> tmp = new TreeMap<>(map); 
    V max_val = tmp.get(tmp.firstKey()) ;
    for(V v : map.values()){
        if(c.compare(v, max_val) > 0) max_val = v;
    }
    for(K k : map.keySet()){
        if(map.get(k).equals(max_val)) a.add(k);
    }
    return a;
    

}

public static void main(String arg[]){
Map<String,Integer> map = new HashMap<>();
map.put("a",5);
map.put("b",3);
map.put("c",0);
map.put("d",5);
Comparator<? super Integer> c = Comparator.naturalOrder(); 
Collection<? super String> a = KeysWith.keysWithHighestValue(map,c);
System.out.println(a);


}
}