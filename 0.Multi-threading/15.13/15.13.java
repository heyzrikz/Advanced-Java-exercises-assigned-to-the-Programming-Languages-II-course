import java.util.HashMap;
import java.util.Map;

class SafeSet<T>{

private Map<T,Boolean> elementi = new HashMap<>();
private final Object mutex = new Object();

public boolean add(T val){
    synchronized(mutex){
        if(elementi.get(val) == null || elementi.get(val) == false){
            elementi.put(val,true);
            return true;
        }else return false;
    }
}

public boolean remove(T val){
    synchronized(mutex){
        if(elementi.get(val) == null) return false;
        if(elementi.get(val) == true){
            elementi.put(val,false);
            return true;
        }
        elementi.remove(val);
        return true;
    }
}

public boolean contains(T val){
    synchronized(mutex){
        if(elementi.get(val) == null) return false;
        return elementi.get(val);
    }
}
public static void main(String[] args) {
    SafeSet<String> a = new SafeSet<>();
System.out.println(a.add("ciao"));
System.out.println(a.add("mondo"));
System.out.println(a.remove("ciao"));
System.out.println(a.contains("ciao"));
System.out.println(a.remove("ciao"));
System.out.println(a.contains("ciao"));
}
}