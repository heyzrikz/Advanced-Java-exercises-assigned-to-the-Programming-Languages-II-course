import java.util.LinkedList;
import java.util.List;

/*
a)non corretta: accetta Collection quando dovrebbe accettare solo List
b)funzionale, completa, corretta, non fornisce ulteriori garanzie, semplicità: 1 solo parametro di tipo, tipo di ritorno specifico: ho una lista di T come parametro e quindi mi aspetto un oggetto di tipo T come tipo di ritorno
c)funzionale, completa, corretta, fornisce garanzie che possiamo aggiungere solo null alla lista, semplicità: 1 solo parametro di tipo, tipo di ritorno specifico
d)funzionale, completa, corretta, fornisce garanzie massime sulla lista, semplicità: 0 parametri di tipo, tipo di ritorno poco specifico: posso restituire solo object quando passo una lista di un tipo specifico e che potrei gestire
e)non completa: accetta solo LinkedList
f)non corretta: posso passare una lista di tipi non assegnabili a S
 */

  class cinqueventiquattro{
    public static <T> T extractPos(List<? extends T> l , int n){
        return l.get(n);
    }

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1); l.add(2); l.add(3);
        Number n = extractPos(l, 1);
        System.out.println(n);
    }
 }