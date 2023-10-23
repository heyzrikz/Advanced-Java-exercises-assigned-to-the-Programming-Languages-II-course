import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class BinRel<T>{
     public static int cao = 0;
    public  class prova{
        //private static int var = 2;
        public  void ciao(){
            cao++;
        }
    } 
    public void c(){

    }

    public static void p(){
        c();
        cao++;
    }

    private Map<T,HashSet<T>> elenco = new HashMap<>();

public void addPair(T v1 , T v2){
    if(elenco.get(v1)!= null){ // O(1)
        elenco.get(v1).add(v2); // O(1)
    }else{
        HashSet<T> tmp = new HashSet<T>();
        tmp.add(v2); // O(1)
        elenco.put(v1,tmp); // O(1)
    }
}

public boolean areRelated(T v1 , T v2){
    HashSet<T> tmp = elenco.get(v1); // O(1)
        if(tmp != null){
            return tmp.contains(v2); // O(1)
        }else return false;
   }


//riutilizzo areRelated con key e val invertite per verificare se esiste un simmetrico
public boolean isSymmetric(){ // O(n)
    for(T key : elenco.keySet()){
        for(T val : elenco.get(key))
        if(!areRelated(val,key)) return false;
    }
    return true;
}

}