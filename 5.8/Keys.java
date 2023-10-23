import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
a)non è completo poichè posso avere nella mappa elementi di tipo differente da value
b)completo, corretto, funzionale, non fornisce garanzie sulla lista, è semplice
c)non è completo poichè posso avere nella mappa elementi di tipo differente da value
d)non è completo poichè posso avere nella mappa elementi di tipo differente da value
e)non è funzionale poichè non posso modificare out
f)non è completo poichè non accetta ogni tipo di List
*/


public class Keys {
  static<K> void keysWithValue(Map<? extends K,?> m , Object value, List<? super K> out){
      for(K k : m.keySet()){
        if(m.get(k).equals(value)) out.add(k);
      }
      for(Object o : out){
          System.out.println(o);
      }

      
  }  
  public static void main(String arg[]){
      Map<Integer,String> m = new HashMap<>();
      m.put(Integer.valueOf(1),"uno");
      m.put(Integer.valueOf(2),"uno");
      String value = "uno";
      List<Number> out = new LinkedList<>();
      Keys.keysWithValue(m, value, out);
      //System.out.println(out);

  }
}
