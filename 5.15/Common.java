import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
a)non è completa pochè accetta due mappe che hanno le chiavi K dello stesso tipo
b)non è completa pochè accetta due mappe che hanno le chiavi K dello stesso tipo
c)funzionale, completa, corretta, offre garanzie su entrambe le mappe, semplicità massima, non è specifico il tipo di ritorno e non è in relazione con i parametri passati al metodo
d)non è funzionale poichè non posso fare la add sul set di ritorno
e)non è funzionale poichè non posso fare la add sul set di ritorno
*/
public class Common {
  static <T> Set<T> commonKeys(Map<? extends T,?> m1,Map<?,?> m2){
    Set<T> set = new HashSet<>();
    for(T k : m1.keySet()){
        if(m2.containsKey(k)) set.add(k);
    }
    return set;
  }  
  public static void main(String arg[]){
      Map<Integer,String> m1 = new HashMap<>();
      Map<String,Number> m2 = new HashMap<>();
      m1.put(1,"ciao");
      m1.put(2, "bello");
      m1.put(3,"non deve comparire");
      m2.put("2", null);
      m2.put("1",2);
      Set<Integer> set = Common.commonKeys(m1, m2);
      System.out.println(set);


  }
}
