import java.util.Iterator;

/*
 a)non completa, accetta solo iteratori di object
 b)non corretta poichè se a e b non sono confrontabili allora non potrò generare un nuovo iteratore che li contenga entrambi
 c)completa, corretta, funzionale, non offre garanzie, semplicità:1, tipo di ritorno specifico
 d)funzionale, completa, corretta, fornisce garanzie su a e b, semplicità: 1, tipo di ritorno specifico
 e)non corretta poichè se a e b non sono confrontabili allora non potrò generare un nuovo iteratore che li contenga entrambi
 f)funzionale, completa, corretta, non fornisce garanzie, semplicità: 2, tipo di ritorno specifico
 */

public class Concat{
    public static <S> Iterator<S> concat(Iterator<? extends S> a , Iterator<? extends S> b){
        return new Iterator<S>(){
            public boolean hasNext(){
                return (a.hasNext() || b.hasNext());
            }

            public S next(){
                if(a.hasNext()) return a.next();
                return b.next();
            }
        };
    }
}