import java.util.ArrayList;
import java.util.List;

/*
a)non funzionale, non posso fare add sul tipo di ritorno
b)non funzionale, non posso fare add sul tipo di ritorno
c)funzionale, completa, non corretta poichè non posso ottenere una lista di tipo diverso dalla lista data in input
d)funzionale, completa, corretta, non offre ulteriori garanzie, semplice, tipo di ritorno specifico
e)funzionale, non completa accetta solo List<Object>

mia soluzione:
*/
class ReverseL{
public static <T> List<T> reverseList(List<? extends T> l){
List<T> ret = new ArrayList<>();
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