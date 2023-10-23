import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
contratto: il metodo accetta una mappa e un comparatore, e restituisce vero se e solo se ciascuna
            chiave è minore o uguale del valore ad essa associato, di conseguenza il tipo delle chiavi
            e il tipo dei valori deve essere confrontabile per il Comparator

a) non funzionale poichè il Comparator<K> non può confrontare le chiavi con i valori
b) non funzionale poichè il Comparator<? super K> non può confrontare le chiavi con i valori
c) funzionale, non completa poichè accetta solo valori di tipo V che estende direttamente K
d) funzionale, non completa poichè accetta mappe solo dello stesso tipo K=V
e) non funzionale poichè Comparator non può confrontare le chiavi e i valori di tipo T
f) funzionale, completa, corretta, offre garanzie sulla mappa, semplicità: 1
g) non funzionale poichè non è possibile avere come parametro un Comparator<?>


*/

class Increasing{
    public static <T> boolean isIncreasing(Map<? extends T, ? extends T> m, Comparator<? super T> c){
        for(T t:m.keySet()){
            if(c.compare(t,m.get(t)) > 0) return false;
        }
        return true;
    }

    public static void main(String arg[]){
        Map<Integer,Double> m = new HashMap<>();
        Comparator<Number> c = new Comparator<Number>() {
            public int compare(Number x ,Number y){
                if(x.doubleValue() > y.doubleValue()) return 1;
                if(x.doubleValue() < y.doubleValue()) return -1;
                return 0;
            }
           
        };
        m.put(0, 1.5);
        m.put(1,1.3);
        m.put(3, 4.1);
        System.out.println(Increasing.isIncreasing(m, c));
    }
}