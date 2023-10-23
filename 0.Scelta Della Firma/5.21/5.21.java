import java.util.HashSet;
import java.util.Set;

/*
contratto: accetta due insiemi a e b che non devono essere necessariamente dello stesso tipo,
           e restituisce un insieme che contiene gli elementi di a meno quelli di b

a) non funzionale, non posso fare la put sul set di ritorno
b) funzionale, completa, corretta, offre garanzie totali sui due set, semplicità massima, tipo di ritorno non specifico
c) funzionale, non completa poichè accetta solo Set di String
d) funzionale, completa, corretta, offre garanzie massime su b, semplicità: 1, tipo di ritorno specifico
e) non completa poichè accetta solo due set che si trovano nella stessa gerarchia
f) non completa poichè accetta solo due set che si trovano nella stessa gerarchia
*/

class Difference{
    public static <T> Set<T> difference(Set<? extends T> a , Set<?> b){
        Set<T> ret = new HashSet<>();
        for(T t :a){
            if(! b.contains(t)) ret.add(t);
        }
        return ret;
    }
}