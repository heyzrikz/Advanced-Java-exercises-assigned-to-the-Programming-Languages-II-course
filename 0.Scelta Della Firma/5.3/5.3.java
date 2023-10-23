import java.util.HashMap;
import java.util.Map;

/*
  a) non è funzionale: non si può costruire la mappa di ritorno
  b) funzionale, completa, corretta, offre garanzie, semplicità: 1, tipo di ritorno poco specifico, possiamo assegnare la mappa restituita solo a Map<K,Object>
  c) non funzionale: la seconda map ha valori assegnabili solo ad Object e la mappa di ritorno accetta V
  d) funzionale, completa, corretta, offre garanzie sulla seconda mappa, semplicità: 1, tipo di ritorno specifico   
  e) non funzionale: posiamo inserire solo null
  f) non completa: accetta solo mappe con valori Object
  */
 
 class cinquetre {
    public static <K,V> Map<K,V> overridingMap(Map<? extends K , ? extends V> map1 , Map<?,? extends V> map2){
        Map<K,V> ret = new HashMap<>();
        for(K k : map1.keySet()){
            if(map2.keySet().contains(k)) ret.put(k,map2.get(k));
            else ret.put(k,map1.get(k));
        }
        return ret;
    }
    public static void main(String[] args) {
        Map<Integer,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        //overridingMap(map1, map2);


    }
}
