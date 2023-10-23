import java.util.HashMap;
import java.util.Map;

public class BoundedMap<K,V>{
private Map<K,Valore> mappa;
private int size_max;

    private class Valore{
        private V value;
        private int count;
        Valore(V v , int c){
            value = v;
            count = c;
        }
    }

BoundedMap(int n){
mappa = new HashMap<K,Valore>();
size_max = n;
}

public void put(K k, V v){
    if(mappa.size() == size_max){
        K rem = null;
        int min = 999999;
        for(K key : mappa.keySet()){
            if(mappa.get(key).count < min){
                min = mappa.get(key).count;
                rem = key;
            }
        }
    mappa.remove(rem);
    }
    mappa.put(k,new Valore(v,0)); 
}

public V get(K key){
    if(mappa.get(key) != null) mappa.get(key).count++;
    else return null;
    return mappa.get(key).value;
}


}