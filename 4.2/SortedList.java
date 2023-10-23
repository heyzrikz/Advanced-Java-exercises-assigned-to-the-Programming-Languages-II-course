import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortedList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> elenco;
    SortedList(){
        elenco = new ArrayList<T>();
    }

    public void add(T v){
        int i = 0;
        while(i<elenco.size() && v.compareTo(elenco.get(i))>0){
            i++;
        }
        elenco.add(i,v);
    }

    public Iterator<T> iterator(){
        return elenco.iterator();
    }

}