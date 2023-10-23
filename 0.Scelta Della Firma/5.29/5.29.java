import java.util.Iterator;

/*
 a) non completa: accetta solo Iterator di Object
 b) 
 c) funzionale, completa, corretta, non offre ulteriori garanzie, semplicità: 1 tipo parametrico, tipo di ritorno specifico
 d) funzionale, completa, corretta, offre garanzie sui due iteratori, semplicità: 1 tipo parametrico, tipo di ritorno specifico
 e) funzionale, completa, non corretta: se T non è assegnabile ad S non sarà possibile scorrere il secondo Iteratore e assegnare il valore all'iteratore di ritorno
 f) funzionale, non completa poichè accetta solo due iteratori con valori T che estendono direttamente S 



 */
class cinqueventinove {
    public static <T> Iterator<T> concat(Iterator<? extends T> a , Iterator<? extends T> b){
        return new Iterator<T>() {
            public boolean hasNext(){
                return a.hasNext() || b.hasNext();
            }

            public T next(){
                if(a.hasNext()) return a.next();
                return b.next();
            }
        };
    }
}
