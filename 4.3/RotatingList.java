import java.util.ArrayList;
import java.util.List;

public class RotatingList<T extends Comparable<T>>{
    private List <T> elenco;
    RotatingList(){
        elenco = new ArrayList<T>();
    }
    
    public void add(T v){
        elenco.add(v);
    }

    public void rotateLeft(){
        elenco.add(elenco.get(0));
        elenco.remove(0);
       
    }

    public void rotateRight(){
        elenco.add(0,elenco.get(elenco.size() - 1));
        elenco.remove(elenco.size() - 1);
    }

    public boolean equals(Object o){
        if(!(o instanceof RotatingList)) return false;
        RotatingList<T> r = (RotatingList<T>) o;
        for(T i : elenco){
            if(!(r.elenco.contains(i))) return false;
        }
        return true;
    }

    public String toString(){
        String ret = "[ ";
        for(T i : elenco){
            ret = ret +  i + " ";
        }
        ret = ret + "]";
        return ret;
    }



}