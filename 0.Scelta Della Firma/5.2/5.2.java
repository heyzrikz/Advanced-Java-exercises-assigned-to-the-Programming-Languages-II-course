import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 a) non completa: accetta solo Collection di Object
 b) non funzionale: impossibile fare .put() sulla mappa di ritorno
 c) non completa: accetta solo Collection di Object
 d) funzionale, completa, corretta, non offre ulteriori garanzie, semplicità: 2 parametri di tipo, tipo di ritorno troppo restrittivo: restituisce una mappa che deve essere estesa direttamente da T
 e) funzionale, completa, corretta, offre la garanzia che alla collection si può aggiungere solo null, semplicità: 1 parametro di tipo, tipo di ritorno non specifico poichè non posso ottenere una Map di K da una Collection di K
 f) funzionale, completa, corretta, oggre garanzie massime sulla Collection, semplicità: 0 tipi parametrici, tipo di ritorno poco specifico poichè posso assegnare il risultato del metodo solo a una Map di Object

 */

class cinquedue {
public static <K> Map<K,Integer> countOccurrences(Collection<? extends K> c){
    Map<K,Integer> ret = new HashMap<>();
    for(K k:c){
        if(ret.get(k) == null) ret.put(k,1);
        else{
            ret.put(k,ret.get(k) + 1);
        }
    }
    return ret;
} 
public static void main(String[] args) {
    List<String> c = new LinkedList<>();
    c.add("uno");
    c.add("due"); c.add("due");
    c.add("tre");c.add("tre");c.add("tre");
    Map<String,Integer> ret = new HashMap<>();
    ret = countOccurrences(c);
    System.out.println(ret);
}   
}
