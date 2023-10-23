import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
a)Funzionale, non completa poichè src e x non devono essere necessariamente dello stesso tipo ATTENZIONE VALE SOLO TRA LISTE QUINDI: Funzionale, Completa, Corretta, non fornisce ulteriori garanzie, semlice
b)Non Funzionale, non posso aggiungere elementi a part1 e part2
c)Funzionale, Completa, non Corretta poichè se T e S sono due classi che non fanno parte della stessa gerarchia non posso dividere src in due parti
d)Funzionale, Completa, Corretta, Fornisce garanzie sulla lista src, Semplicità garantita
e)Funzionale, Completa, non corretta poichè per tipi di x che non fanno parte della gerarchia di T gli elementi di src non sono confrontabili con x
*/
public class Split{
static <T> void splitList(List<T> src , T x , List<? super T> part1 , List<? super T> part2){
        boolean jump = false;
        for(T t: src){
            if(t.equals(x)) jump = true;
            if(jump == true){
                part2.add(t);
            }else{
                part1.add(t);
            }
        }

}
public static void main(String arg[]){
    List<Object> src = new ArrayList<>();
    src.add(1); src.add(2); src.add(3);
    src.add(4); src.add(5); src.add(6);

    Integer x = 3;

    List<Object> part1 = new ArrayList<>();
    List<Object> part2 = new LinkedList<>();

    Split.splitList(src,x,part1,part2);
    System.out.println(part1);
    System.out.println(part2);

}

}