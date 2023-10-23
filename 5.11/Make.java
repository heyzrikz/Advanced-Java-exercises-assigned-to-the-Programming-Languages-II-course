import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
a)non funzionale poichè non possiamo aggiungere elementi alla map di ritorno
b)non funzionale poichè non possiamo aggiungere elementi alla map di ritorno
c)non funzionale poichè alla Map come valore di V possiamo passare solo Object
d)non completa poichè accetta solo liste nella stessa gerarchia
e)non è funzionale poichè Object non è assegnabile a ?
f)funzionale,non completa, poichè accetta solo liste nella stessa gerarchia
*/
public class Make {
    //verifica con Map<Integer, String> con Liste Integer String
  static<K,V> Map<K,V> makeMap(List<? extends K> keys,List<? extends V> vals){
    int i = 0;
    Map<K,V> map = new HashMap<>();
    for(K k : keys){
        map.put(k,vals.get(i));
        i++;
    }
    return map;
  } 
  
  public static void main(String arg[]){
      Map<Number,String> map;
      List<Integer> keys = new LinkedList<>();
      List<String> vals = new LinkedList<>();
      keys.add(1);
      keys.add(2);
      keys.add(3);
      vals.add("uno");
      vals.add("due");
      vals.add("tre");
      map = Make.makeMap(keys, vals);
      System.out.println(map);
  }
}
