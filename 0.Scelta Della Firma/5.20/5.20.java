import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
contratto: il metodo deve poter accettare qualsiasi tipo di Lista

a) funzionale, completa, corretta, offre garanzie massime sulla lista, semplicità massima, tipo di ritorno poco specifico
b) non è funzionale poichè non è possibile fare add sulla lista di ritorno
c) funzionale, completa, corretta, offre garanzie massime sulla lista, semplicità massima, tipo di ritorno poco specifico
d) funzionale, completa, corretta, non offre garanzie sulal lista, semplicità: 1, tipo di ritorno specifico
e) non completa poichè accetta solo List<Object>
*/

class Reverse{
    public static <T> List<T> reverseList(List<? extends T> l){
        List<T> ret = new LinkedList<>();
        for(int i = l.size() - 1; i >= 0 ; i--){
            ret.add(l.get(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1); l.add(2); l.add(3);
        List<Integer> ret = reverseList(l);
        System.out.println(ret); 
    }
}