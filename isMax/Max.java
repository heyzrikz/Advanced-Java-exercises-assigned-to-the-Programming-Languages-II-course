import java.util.Collection;
import java.util.Comparator;

/*
a)non è completo poichè accetta solo Set di Object
b)non è completo poichè accetta solo Set dello stesso tipo di x
c)non è completo poichè accetta solo Set dello stesso tipo di x
d)non è funzionale 
e)è corretto, non è funzionale poichè non posso leggere il set
f)è corretto, è funzionale, è completo , non fornisce ulteriori garanzie per il Set, non è abbastanza semplice

mia soluzione:

*/
public class Max {
<T> boolean isMax(T x, Comparator<? super T> c , Set<? extends T> s){
    for(T i : s){
        if(c.compare(x,i) < 0) return false;
    }
    return true;
}    
}
