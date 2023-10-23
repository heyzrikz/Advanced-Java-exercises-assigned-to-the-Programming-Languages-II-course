import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
info aggiuntive pre-contratto: il metodo può accettare anche valori che non siano dello stesso tipo dei valori della mappa
a) funzionale, non completa poichè accetta solo value dello stesso tipo dei valori della mappa
b) funzionale, non completa poichè accetta solo List di Object
c) funzionale, non completa poichè accetta solo value dello stesso tipo dei valori della mappa
d) non funzionale, non è possibile fare l'add nella lista
e) non funzionale, non è possibile fare l'add nella lista
f) funzionale, non completa poichè accetta solo Linked List

 */

class cinqueotto {
 public static <K> void keysWithValue(Map<? extends K,?> m , Object value , List<? super K> out){
     for(K k : m.keySet()){
         if(m.get(k).equals(value)) out.add(k);
     }
 }
 
 public static void main(String[] args) {
     Map<Integer,String> m = new HashMap<>();
     m.put(1,"uno");
     m.put(2, "due");
     m.put(3,"tre");
     m.put(22, "due");
     List<Integer> out = new LinkedList<>();
     keysWithValue(m, "due", out);
     System.out.println(out);
 }
 
}
