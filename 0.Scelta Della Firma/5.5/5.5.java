import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 a)non completa: accetta solo map con valori di tipo Object
 b)non completa: accetta solo map con valori di tipo uguali al tipo di k
 c)non funzionale: Comparator non può essere di tipo ?
 d)funzionale, completa, corretta, offre garanzie massime sulla mappa, semplicità: un parametro, tipo di ritorno non specifico
 e)non funzionale: posso scorrere la mappa solo con Object e il tipo di ritorno è un Set<T>
 */


 class cinquecinque {
    public static <K,V> Set<K> keysWithHighestValue(Map<? extends K,? extends V> map , Comparator<? super V> c){
        Set<K> ret = new HashSet<>();
        V max = null;
        for(V val: map.values()){
        max = val;
        break;
    }
        for(K k : map.keySet()){
            if(c.compare(map.get(k),max) == 0) ret.add(k);
            else if(c.compare(map.get(k), max) > 0){ret.clear(); ret.add(k); max = map.get(k);}
        }
        return ret;
    }
public static void main(String[] args) {
    Map<String,Integer> map = new HashMap<>();
    map.put("a",5);
    map.put("b",3);
    map.put("c",0);
    map.put("d",5);
    Comparator<? super Integer> c = Comparator.naturalOrder(); 
    Set<Object> a = keysWithHighestValue(map,c);
    System.out.println(a);
}
}
