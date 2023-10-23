import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;


/*

 */
public class Find{
static <T> T findPrevious(Collection<? extends T> col, T x , Comparator<? super T> c){
    ArrayList<? extends T > a = new ArrayList<>(col);
    a.sort(c);
    int i = 1;
    T max = a.get(a.size() - i);
    while( c.compare(max, x) >= 0 ){
        i++;
        if(a.size() - i >= 0) max = a.get(a.size() - i);
        else return null;
    }
    return max;
}
public static void main(String arg[]){
LinkedList<Integer> col = new LinkedList<>();
col.add(4);
col.add(1);
col.add(6);
Number x = 7;
Comparator<Number> c = new Comparator<Number>() {
    public int compare(Number a,Number b){
        if(a.doubleValue() > b.doubleValue()) return 1;
        if(a.doubleValue() < b.doubleValue()) return -1;
        return 0;
    }
}; 
System.out.println(Find.findPrevious(col, x, c));
}
}