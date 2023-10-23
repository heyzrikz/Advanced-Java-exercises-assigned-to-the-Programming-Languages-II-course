import java.util.HashMap;
import java.util.Map;

/*
contratto: le chiavi della mappa a devono essere compatibili con le chiavi della mappa c,
           se un valore di a non è presente come chiave in b solleva un'eccezione

a) funzionale, non è completa poichè accetta solo mappe con valore di a e chiave di b dello stesso esatto tipo
b) funzionale, non completa poichè la seconda mappa dovrebbe accettare qualsiasi tipo
c) funzionale, non completa poichè la seconda mappa dovrebbe accettare qualsiasi tipo
d) funzionale, completa, corretta, offre garanzie sulle due mappe, semplicità: 2, tipo di ritorno specifico
e) non completa, accetta solo a con valori di tipo object e b con chiavi di tipo object
*/

class Compose{
    public static <S,U> Map<S,U> composeMap(Map<? extends S,?> a , Map<?,U> b){
        Map<S,U> ret = new HashMap<>();
        for(S s: a.keySet()){
            if(b.get(a.get(s)) == null) throw new RuntimeException();
            ret.put(s,b.get(a.get(s)));
        }
        return ret;
    }

    public static void main(String[] args) {
        Map<Integer,Double> a = new HashMap<>();
        Map<Double,String> b = new HashMap<>();
        a.put(1,1.0);a.put(2,2.0);a.put(3,3.0);
        b.put(1.0,"uno");b.put(2.0,"due");b.put(3.0,"tre");
        System.out.println(composeMap(a,b));
        
    }
}