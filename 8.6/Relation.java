import java.util.HashSet;
import java.util.LinkedList;

public class Relation<T extends Comparable<T>,E extends Comparable<E>>{

    LinkedList<T> list_l = new LinkedList<T>();
    LinkedList<E> list_r = new LinkedList<E>();

    public void put(T l , E r){
        list_l.add(l);
        list_r.add(r);
    }

    public void remove(T l , E r){
        for(int i = 0 ; i < list_l.size() ; i++){
            if(list_l.get(i).equals(l) && list_r.get(i).equals(r)){
                list_l.remove(i);
                list_r.remove(i);
            }
        }
    }

    public HashSet<E> image(T l){
        HashSet<E> h = new HashSet<E>();
        for(int i=0;i<list_l.size();i++){
            if(list_l.get(i).equals(l)){
                h.add(list_r.get(i));
            }
        }
        return h;
    }
    public HashSet<T> preImage(E l){
        HashSet<T> h = new HashSet<T>();
        for(int i=0;i<list_r.size();i++){
            if(list_r.get(i).equals(l)){
                h.add(list_l.get(i));
            }
        }
        return h;
    }


}