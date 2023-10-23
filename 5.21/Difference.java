import java.util.HashSet;
import java.util.Set;

/*
a)non funzionale, impossibile fare add sul set di ritorno
b)funzionale, completa, corretta, offre garanzie massime sui parametri, semplicità firma, non è specifica sul tipo di ritorno
c)funzionale,non completa poichè accetta solo set di Stringhe
d)funzionale, completa, corretta, offre garanzie su b, semplice, tipo di ritorno specifico
e)funzionale, non completa poichè b non deve essere per forza sottotipo del set di ritorno
f)funzionale, non completa poichè b non deve essere per forza sottotipo del set di ritorno

mia soluzione
*/
class Difference{
    public static <T> Set<T> difference(Set<? extends T> a , Set<?> b){
        Set<T> ret = new HashSet<>();
        for(T t:a){
            if(! b.contains(t)) ret.add(t);
        }
        return ret;
    }
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<String> b = new HashSet<>();
        a.add(1);a.add(2);a.add(3);
        b.add("2");b.add("4");
        Set<Number> ret = difference(a, b);
        System.out.println(ret);
    }
}