import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Prova {
    public static void prova(String arg[]){
        ArrayList<Manager> a = new ArrayList<>();
        a.add(new Manager());
        Map<? super Person,Integer> m = Employee.countOccurrences(a);
        
    }
}

class Person{

}

class Employee extends Person{
    static <K> Map<? extends K,Integer> countOccurrences(Collection<? super K> c){
        Map<? extends K,Integer> m = new HashMap<>();
        for(Object k:c){
            m.put(k, 3);
        }
        return m;
    }
}

class Manager extends Employee{

}
