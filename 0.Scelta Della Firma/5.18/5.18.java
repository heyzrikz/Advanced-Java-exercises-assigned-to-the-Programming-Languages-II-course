import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
contratto: dati in input una lista src, due liste part1 e part2 e un elemento x,
            l'elemento x non deve essere obbligatoriamente dello stesso tipo T della lista src,
            in questo caso verrà inserito tutta la prima lista nella parte 1

a) funzionale, non completa poichè accetta solo x dello stesso tipo della lista src
b) non funzionale poichè non è possibile inserire elementi nelle due liste
c) non è funzionale poichè non è possibile inserire elementi di tipo S nelle due liste di tipo T
d) funzionale, non completa poichè accetta solo x di tipo T che si trova nella stessa gerarchia del tipo della Lista di src
e) funzionale, completa, corretta, offre garanzie sulle due liste part1 e part2, semplicità: 1
*/

class Split{
    public static <T> void splitList(List<? extends T> src, Object x , List<? super T> part1, List<? super T> part2){
        boolean insert_part1 = true;
        for(T t : src){
            if(t.equals(x)) insert_part1 = false;
            if(insert_part1 == true){
                part1.add(t);
            }else part2.add(t);
        }
    }

    public static void main(String arg[]){
        List<Object> src = new ArrayList<>();
        src.add(1); src.add(2); src.add(3);
        src.add(4); src.add(5); src.add(6);
    
        String x = "3";
    
        List<Object> part1 = new ArrayList<>();
        List<Object> part2 = new LinkedList<>();
    
        Split.splitList(src,x,part1,part2);
        System.out.println(part1);
        System.out.println(part2);
    
    }
}