import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ForgetfulSet<T>{
    private Set<T> set;
    private Map<T,Long> map = new HashMap<>();
    private long attesa;
    private Object mutex = new Object();
    public ForgetfulSet(long millis){
        attesa = millis;
        set = new HashSet<T>();
    }

    public void add(T val){
        new Thread(new Runnable(){
            public void run(){
                synchronized(mutex){
                    set.add(val);
                }
                try {
                    Thread.sleep(attesa);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized(mutex){
                    set.remove(val);
                }
            }
        }).start();
    }

    public void addV2(T val){
        synchronized(mutex){
            map.put(val,System.currentTimeMillis() + attesa);
        }
    }

    public boolean containsV2(T val){
        synchronized(mutex){
            if(map.get(val) != null)
            return map.get(val) > System.currentTimeMillis();
            return false;
        }
    }

    public boolean contains(T val){
        synchronized(mutex){
            return set.contains(val);
        }
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        ForgetfulSet<String> s = new ForgetfulSet<String>(1000);
s.addV2("uno");
s.addV2("due");
System.out.println(s.containsV2("uno") + ", " + s.containsV2("due") + ", " + s.containsV2("tre"));
Thread.sleep(800);
s.addV2("tre");
System.out.println(s.containsV2("uno") + ", " + s.containsV2("due") + ", " + s.containsV2("tre"));
Thread.sleep(800);
System.out.println(s.containsV2("uno") + ", " + s.containsV2("due") + ", " + s.containsV2("tre"));

    }
}