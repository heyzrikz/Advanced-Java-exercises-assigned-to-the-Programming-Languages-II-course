import java.util.HashMap;
import java.util.Map;

/*
a) non funzionale, posso leggere la mappa passata come parametro solo con Object
b) non funzionale, posso fare solo put(null) nella mappa di ritorno
c) funzionale, completa, corretta, non offre ulteriori garanzie, semplicità: 1, tipo di ritorno specifico
d) non è funzionale poichè posso aggiungere alla mappa di ritorno solo chiavi di tipo Object
e) non funzionale poichè non posso aggiungere alla mappa di ritorno V come chiave e K come valore
f) funzionale, completa, corretta, offre garanzie sulla mappa data in input, semplicità: 2, tipo di ritorno specifico

*/

class Inverse{
    public static <K,V> Map<K,V> inverseMap(Map<? extends V , ? extends K> m){
        Map<K,V> ret = new HashMap<>();
        for(V v: m.keySet()){
            if(ret.get(m.get(v)) != null) throw new RuntimeException();
            ret.put(m.get(v),v);
        }
        return ret;
    }

    public static void main(String[] args) {
        Map<String,Integer> ret = new HashMap<>();
        ret.put("uno",1);
        ret.put("due",2);
        ret.put("tre",3);
        Map<Number,Object> r = Inverse.inverseMap(ret);
        System.out.println(r);
        
    }
}