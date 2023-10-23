import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountByType{
    public static void countByType(List<?> list){
        Map<Class<?>,Integer> contatore = new HashMap<>();
        for(Object o : list){
            if(contatore.get(o.getClass()) == null) contatore.put(o.getClass(),1);
            else contatore.put(o.getClass(),contatore.get(o.getClass()) + 1);
        }

        for(Class<?> c : contatore.keySet()){
            System.out.println(c+" : "+contatore.get(c));
        }
    }

    public static void main(String[] args) {
        List<Number> l = new LinkedList<Number>();
        l .add(new Integer(3));
        l .add(new Double(4.0));
        l .add(new Float(7.0f));
        l .add(new Integer(11));
            countByType(l);
    }
}