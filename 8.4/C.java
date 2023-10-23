import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class B<T> implements Iterable{
    B(){}
    B(T var){

    }

    public static String buildMessage(Object a){
        return "ciao";
    }

    public boolean check(Set<Integer> s1,Integer n){
        return true;
    }

    public Set<Number> process(Set<?> s1 , Set<?> s2,Integer n){
        return new HashSet<Number>();
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}