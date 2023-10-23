import java.util.Comparator;

/*
a) funzionale, completa, corretta, non offre garanzie, semplicità: 1, tipo di ritorno specifico
b) non funzionale non è possibile passare un Comparator<?>
c) non funzionale, impossibile utilizzare i comparator dati come input per confrontare due elementi di tipo S
d) funzionale, completa, corretta, offre garanzie sui comparatori, semplicità: 1 , tipo di ritorno specifico
e) non completa, accetta solo Comparator<Object>
f) funzionale, completa, corretta, offre garanzie su tipo di ritorno e parametri, semplicità: 1 , tipo di ritorno specifico


*/

class Combine{
    public static <T> Comparator<T> combine(Comparator<? super T> a , Comparator<? super T> b){
        return new Comparator<T>(){
            public int compare(T t1 , T t2){
                if(a.compare(t1,t2) == 0) return b.compare(t1,t2);
                else return a.compare(t1,t2);
            }
        };
    }

    public static void main(String[] args) {
        Comparator<Number> b =new Comparator<Number>() {
            public int compare(Number a , Number b){
                if(a.doubleValue()>=b.doubleValue()) return 1;
                else return -1;
            }
        };

        Comparator<Integer> a = Comparator.naturalOrder();
        Comparator<Integer> ret = combine(a, b);
        System.out.println(ret.compare(1, -1));
    }
}