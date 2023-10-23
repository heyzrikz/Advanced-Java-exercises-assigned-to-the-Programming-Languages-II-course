import java.util.Iterator;
import java.util.Set;

public class A extends B<Object> {
    private B<?> b;
    private String msg;
    public A() {
    b = new B<Object>(null);
    msg = B.<A>buildMessage(this);
    }
    public Set<? super Number> f(Set<Integer> set1, Set<String> set2) {
    for (Integer n: b)
    if (b.check(set1, n))
    return b.process(set1, set2, n);
    return b.process(set2, set1, null);
    }
    }

    class B<T> implements Iterable<Integer>{

        B(){

        }

        B(Object o){

        }

        public static String buildMessage(A a){
            return "";
        }

        public boolean check(Set<Integer> s1, Integer n){
            return false;
        }

        public Set<Object> process(Set<?> s1 , Set<?> s2 , Integer n){
            return null;
        }


        public Iterator<Integer> iterator(){
            return null;
        }

    }
    
