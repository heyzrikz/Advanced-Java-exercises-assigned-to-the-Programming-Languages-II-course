import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class BinRel<T>{

    private List<Pair<T,T>> elenco = new ArrayList<>();

    

public void addPair(T v1 , T v2){
    elenco.add(new Pair<T,T>(v1,v2));
}

public boolean areRelated(T v1 , T v2){
    return elenco.contains(new Pair<T,T>(v1,v2));
}

public boolean isSymmetric(){
    for(Pair<T,T> p : elenco){
        if(!areRelated(p.getValue(),p.getKey())) return false;
    }
    return true;
}

}