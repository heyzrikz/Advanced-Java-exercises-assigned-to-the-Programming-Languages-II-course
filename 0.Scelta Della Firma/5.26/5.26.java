import java.util.Comparator;
import java.util.Set;

/*
estensione del contratto: il tipo dell'oggetto x deve essere confrontabile con il tipo degli elementi dell'insieme
                            tramite il comparatore

a) non completo poichè accetta solo Comparator<Object>
b) funzionale, non completa poichè accetta solo un oggetto x di tipo uguale a quello del Set
c) funzionale, non completa poichè accetta solo un oggetto x di tipo uguale a quello del Set
d) non funzionale poichè il Comparator non può confrontare x e gli elementi del Set
e) non funzionale poichè il set s si può scorrere solo con Object e il Comparatore non può confrontare Object e tipo T
f) non è completo poichè accetta solo x di T che estende direttamente S


*/

class Max{
    public static <T> boolean isMax(T x , Comparator<? super T> c , Set<? extends T> s){
        for(T t:s){
            if(c.compare(x,t) < 0 ) return false;
        }
        return true;
    }
}