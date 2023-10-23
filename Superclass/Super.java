import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Super{
    public static Class<?> getSuperclasses(Object o) throws InstantiationException, IllegalAccessException{
            if(o.getClass().getSuperclass() == Object.class){ return o.getClass();}
            else return getSuperclasses(o.getClass().getSuperclass().newInstance());
        
    }

    public static <T> T getByType(Collection<T> c ,Class<? extends T> x ){
        for(T i : c){
            if(i.getClass() == x) return i;
        }
        return null;
    }

    public static <T> void countByType(List<T> l){
        Map<Class<? extends Object>,Integer> map = new HashMap<>();
        for(Object i : l){
            if(map.get(i.getClass()) == null) map.put(i.getClass(),Integer.valueOf(1));
            else map.put(i.getClass(),map.get(i.getClass()) + 1);
        }
        for(Class<? extends Object> i : map.keySet()){
            System.out.println(i.toString()+" : "+map.get(i));
        }
    }
}