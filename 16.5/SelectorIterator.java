import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectorIterator<T extends Comparable<T>> implements Iterable<T>{

private T curr;
private Selector<T> sel;
private List<T> list;
private int index = 0;
SelectorIterator(List<T> l , Selector<T> s){
    sel = s;
    list = l;
    while(index < list.size() && ! sel.select(list.get(index)))
        index++;
    if(index < list.size()){
        curr = list.get(index);
        index++;
    }
}




public Iterator<T> iterator(){
    return new Iterator<T>(){
        public boolean hasNext(){
            if(curr != null) return true;
                return false;
        }

        public T next(){
            T temp = curr;
            while(index < list.size() && ! sel.select(list.get(index)))
            index++;
            if(index < list.size()){ curr = list.get(index); index++;}else curr = null;
            return temp;
        }




    };


}



}