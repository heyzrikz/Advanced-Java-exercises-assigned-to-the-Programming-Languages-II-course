import java.util.HashMap;
import java.util.Map;

class ForgetfulSet<T>{
    private Map<T,Long> elementi;
    private final Object mutex = new Object();
    private long millis;

    public ForgetfulSet(long millis){
        this.millis = millis;
        elementi = new HashMap<T,Long>();
    }

    public void add(T elem){
        synchronized(mutex){
            elementi.put(elem,System.currentTimeMillis() + millis);
        }
    }

    public boolean contains(T elem){
        synchronized(mutex){
            if(elementi.get(elem) == null) return false;
            if(elementi.get(elem) < System.currentTimeMillis()) return false;
            return true;
        }
    }
}

class UseCase{
    public static void main(String[] args) throws InterruptedException {
        ForgetfulSet<String> s = new ForgetfulSet<String>(1000);
        s.add("uno");
        s.add("due");
        System.out.println(s.contains("uno") + ", " + s.contains("due") + ", " + s.contains("tre"));
        Thread.sleep(800);
        s.add("tre");
        System.out.println(s.contains("uno") + ", " + s.contains("due") + ", " + s.contains("tre"));
        Thread.sleep(800);
        System.out.println(s.contains("uno") + ", " + s.contains("due") + ", " + s.contains("tre")); 
    }
}