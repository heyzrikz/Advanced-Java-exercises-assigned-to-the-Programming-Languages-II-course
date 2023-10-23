import java.util.HashMap;
import java.util.Map;

class ForgetfulSet<T>{
    private final long millis;
    private Map<T,Long> elementi;
    private final Object mutex = new Object();

    public ForgetfulSet(long millis){
        this.millis = millis;
        this.elementi = new HashMap<T,Long>();
    }

    public void add(T val){
        synchronized(mutex){
            elementi.put(val,System.currentTimeMillis() + millis);
        }
    }

    public boolean contains(T val){
        synchronized(mutex){
            if(! elementi.keySet().contains(val)) return false;
            if(elementi.get(val) < System.currentTimeMillis()){
                elementi.remove(val);
                return false;
            }
            return true;
        }
    }

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