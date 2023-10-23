import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
pre condizione: il metodo accetta un insieme e un oggetto di tipo CONFRONTABILE e non necessariamente dello stesso tipo, e un comparatore

a) non funzionale poichè non è possibile utilizzare un Comparator<?>
b) funzionale, non completo poichè accetta un Set e un oggetto x che possono essere SOLO dello stesso tipo T
c) non funzionale, il Comparator non si può applicare agli elementi del Set e a x
d) funzionale, non completo poichè accetta un Set e un oggetto x che possono essere SOLO dello stesso tipo T
e) funzionale, non completo poichè accetta un Set e un oggetto x che possono essere SOLO dello stesso tipo T
f) non funzionale il Comparator non si può applicare agli elementi del Set e a x

*/

class Find{
    public static <T> T findPrevious(Set<? extends T> set, Comparator<? super T> comp, T x){
        T max = null;
        for(T t: set){
            if(comp.compare(t,x) < 0 && (max == null || comp.compare(t,max) > 0)) max = t;
        }
        return max;
    }

    public static void main(String arg[]){
        Set<Integer> col = new HashSet<>();
        col.add(4);
        col.add(1);
        col.add(6);
        Integer x = 7;
        Comparator<Integer> c = Comparator.naturalOrder(); 
        System.out.println(Find.findPrevious(col, c, x));
        }
}