import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
 a)funzionale, completa, corretta, offre garanzie sui set in input, semplicità: 1 parametro di tipo, tipo di ritorno specifico
 b)non funzionale non posso applicare Comparator<Object> sui tipi S e T
 c)funzionale, non completa poichè accetta solo set dello stesso tipo T
 d)non completo poichè accetta solo Set di tipo S e T tale che T estende direttamente S
 e)non funzionale, il Comparator deve essere di tipo superiore dei tipi dei Set 
 */

class Main{
    public static <T> T gLB(Set<? extends T> a ,Set<? extends T> b,Comparator<? super T> c){
        T max_a = null;
        T min_b = null;
        for(T t: b){
            if(min_b == null) min_b = t;
            else if(c.compare(t,min_b) < 0) min_b = t;
        }

        Set<T> tmp = new HashSet<>();
        for(T t:a){
            if(c.compare(t, min_b) < 0) tmp.add(t);
        } 

        for(T t: tmp){
            if(max_a == null) max_a = t;
            else if(c.compare(t,max_a) > 0) max_a = t;
        }
        return max_a;

    }
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        a.add(5); a.add(20); a.add(30);
        Set<Integer> b = new HashSet<>();
        b.add(25);b.add(26); b.add(30);
        Comparator<Integer> c = Comparator.naturalOrder();
        System.out.println(gLB(a,b,c));
    }
}