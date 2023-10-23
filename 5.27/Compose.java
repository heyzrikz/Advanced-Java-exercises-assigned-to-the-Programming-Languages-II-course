import java.util.HashMap;
import java.util.Map;

/*
 a)funzionale, completa, corretta, non offre garanzie, semplicità firma: 3, tipo di ritorno specifico
 b)funzionale, completa, corretta, offre garanzie su b, semplicità: 2, tipo di ritono specifico
 c)funzionale, completa, corretta, offre garanzie su b, semplicità: 2, tipo di ritono specifico 
 d)correttezza dipende da come intendiamo il contratto, se accettiamo che i valori di a possono essere di tipo diverso da b oppure no, nel mio caso ho scelto di no, non corretta
 e)non completa, accetta solo mappe di object
 */

public class Compose{
public static <S,T,U> Map<S,U> composeMap(Map<? extends S,T> a , Map<? extends T,U> b){
    Map<S,U> ret = new HashMap<>();
    for(S s: a.keySet()){
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