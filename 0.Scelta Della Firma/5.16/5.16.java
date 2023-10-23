import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
contratto: il metodo accetta un insieme, un comparatore e un oggetto x, e restituisce il più piccolo oggettto
            dell'insieme che è maggiore di x secondo il comparatore, di conseguenza x e il Set devono essere di
            tipo confrontabile

a) non funzionale poichè non è possibile confrontare i due oggetti con un Comparator<?>
b) funzionale, non completo poichè accetta solo Set e x di tipo T che estende direttamente il tipo S del comparatore
c) non funzionale, il comparatore non può essere di tipo "inferiore" al tipo del Set e di x
d) funzionale, completo, corretto, non offre ulteriori garanzie sul set, semplicità: 1, tipo di ritorno specifico
e) non funzionale poichè con Comparator<T> non è possibile confrontare Object e T

*/

class Next{
    public static <T> T findNext(Set<? extends T> set, Comparator<? super T> comp, T x){
        T min = null;
        for(T t : set){
            if(comp.compare(t,x) > 0 && (min == null || comp.compare(min,t) > 0)) min = t;     
        }
        return min;
    }

    public static void main(String arg[]){
        Set<Integer> set = new HashSet<>();
        Comparator<Number> comp = new Comparator<Number>(){
            public int compare(Number x ,Number y){
                if(x.doubleValue() > y.doubleValue()) return 1;
                if(x.doubleValue() < y.doubleValue()) return -1;
                return 0;
            }
        };
        set.add(2);
        set.add(5);
        set.add(6);
        System.out.println(Next.findNext(set,comp,new Integer(3)));
    }

    
}

