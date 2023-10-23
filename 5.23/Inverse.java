import java.util.HashMap;
import java.util.Map;

/*
 a)non funzionale poichè posso scorrere la mappa m solo con Object
 b)non funzionale poichè posso aggiungere solo null alla mappa di ritorno
 c)funzionale, completa, corretta, non offre ulteriori garanzie, semplicita: 2 , tipo di ritono specifico
 d)non funzionale poichè posso accedere ai valori K solo con Object
 e)funzionale, non corretta poichè non posso ottenere una mappa con gli stessi tipi di valori di quella passata come parametro
 f)funzionale, completa, corretta, offre garanzie, semplicità: 2 , specificità tipo di ritorno
 */
public class Inverse{
    public static <K,V> Map<K,V> inverseMap(Map<? extends V, ? extends K> map){
        Map<K,V> ret = new HashMap<>();
        for(V v: map.keySet()){
            if(ret.get(map.get(v)) != null) throw new RuntimeException();
            ret.put(map.get(v),v); 
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