import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
pre condizione: il metodo accetta una lista di chiavi e una lista di valori di pari lunghezza,
            non necessariamente di tipo confrontabile
a) non funzionale poichè non è possibile fare put nella mappa di ritorno
b) non funzionale poichè non è possibile fare put nella mappa di ritorno
-> c) non funzionale poichè List<?> si può leggere solo con Object ma la mappa di ritorno accetta solo V come valore
d) funzionale, non completa poichè accetta solo due liste di tipo che estende T nella gerarchia
e) funzionale, non completa poichè accetta come seconda lista solo List<Object>
f) funzionale, non completa poichè accetta una Lista di V che estende direttamente solo K


*/


class Make{
    public static <K,V> Map<K,V> makeMap(List<? extends K> keys, List<? extends V> vals){
        Map<K,V> ret = new HashMap<>();
        for(int i = 0 ; i < keys.size(); i++){
            ret.put(keys.get(i),vals.get(i));
        }
        return ret;
    }

    //c) NON SI PUO' FARE!
    /*public static <K,V> Map<K,V> makeMap2(List<K> keys, List<?> vals){
        Map<K,V> ret = new HashMap<>();
        for(int i = 0 ; i < keys.size(); i++){
            ret.put(keys.get(i),vals.get(i));
        }
        return ret;
    }*/
        public static void main(String arg[]){
            Map<Number,String> map;
            List<Integer> keys = new LinkedList<>();
            List<String> vals = new LinkedList<>();
            keys.add(1);
            keys.add(2);
            keys.add(3);
            vals.add("uno");
            vals.add("due");
            vals.add("tre");
            map = Make.makeMap(keys, vals);
            System.out.println(map);
        }
    }
