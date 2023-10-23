import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
contratto: il metodo accetta due mappe (anche con chiavi di tipo diverso), e restituisce l'insieme delle chiavi
            che compaiono in entrambe le mappe

a) funzionale, non completa poichè accetta solo mappe dello stesso tipo T
b) funzionale, non completa poichè accetta solo mappe dello stesso tipo T
c) funzionale, completa, corretta, offre garanzie massime, semplicità massima, tipo di ritorno poco specifico
d) non funzionale poichè è impossibile fare add nel Set di ritorno
e) non funzionale poichè è impossibile fare add nel Set di ritorno

*/
class Common{
    public static <K> Set<K> commonKeys(Map<? extends K,?> m1 , Map<?,?> m2){
        Set<K> ret = new HashSet<>();
        for(K k:m1.keySet()){
            if(m2.keySet().contains(k)) ret.add(k);
        }
        return ret;
    }

    public static void main(String arg[]){
        Map<Integer,String> m1 = new HashMap<>();
        Map<Object,Number> m2 = new HashMap<>();
        m1.put(1,"ciao");
        m1.put(2, "bello");
        m1.put(3,"non deve comparire");
        m2.put(2, null);
        m2.put(1,2);
        Set<Integer> set = Common.commonKeys(m1, m2);
        System.out.println(set);
  
  
    }
}

