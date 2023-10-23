import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
pre condizione: prende come argomento tre liste, di cui i tipi di A e B devono essere assegnabili al tipo di C
a) funzionale, non completo poichè accetta solo Liste dello stesso tipo parametrico
-> b) funzionale, non completo poichè accetta le liste A e B solo di tipo che estende direttamente il tipo di C
c) funzionale, non completa poichè accetta come lista C solo Object
d) non funzionale poichè è possibile scorrere le due liste solo con Object che non è assegnabile a C
e) funzionale, non completa poichè accetta le due Liste A e B che devono essere necessariamente dello stesso tipo
*/

class Interleave{
    //funzionale, completa (accetta anche 3 liste di tipo diverso pur mantenendo la correttezza della precondizione), corretto, offre garanzie su tutte 3 le liste, semplicità: 1 tipo parametrico
    public static <S> void interleave(List<? extends S> a , List<? extends S> b , List<? super S> c){
        int i = 0;
        while(i < a.size() && i < b.size()){
            c.add(a.get(i));
            c.add(b.get(i));
            i++;
        }
        while(i>= a.size() && i < b.size()){
            c.add(b.get(i));
            i++;
        }

        while(i>= b.size() && i < a.size()){
            c.add(a.get(i));
            i++;
        }
    }

    public static void main(String arg[]){
        LinkedList<Integer> a = new LinkedList<>();
        ArrayList<Double> b = new ArrayList<>();
        ArrayList<Number> c = new ArrayList<>();
        a.add(1);
        b.add(2.0);
        a.add(3);
        a.add(5);
        b.add(4.0);
        a.add(6);
        interleave(a, b, c);
        System.out.println(c);
        }
}