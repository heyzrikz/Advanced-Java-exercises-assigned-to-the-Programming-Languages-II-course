import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BoundedSet<T>{
    private Set<T> elenco;
    private int size;
    private int n_elem;
    private int first_index;
    private ArrayList<T> ordine;
    
    BoundedSet(int s){
        if( s <= 0 ) throw new IllegalArgumentException();
        size = s;
        n_elem = 0;
        first_index = 0;
        elenco = new HashSet<T>();
        ordine = new ArrayList<T>();
    }

    public int size(){ //O(1)
        return size;
    }

    public void add(T value){ // O(1)
        if(!contains(value)){
        if(n_elem == size ){
            elenco.remove(ordine.get(first_index));
            n_elem--;
            first_index++;
        }
            elenco.add(value);
            ordine.add(value);
            n_elem++;
    }
        
    }

    public boolean contains(T value){ // O(1)
        return elenco.contains(value);
    }

}