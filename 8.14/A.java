import java.util.Iterator;

public class A {
    public interface Convertible<T> {
    public T convert();
    }
    private Convertible<A> x = new B();
    private Iterable<A> y = new B(3);
    private Iterable<A> z = B.g(x);
    private Iterable<? extends B> t = B.g(B.b);
    }
    


    class B extends A implements A.Convertible<A> , Iterable<A>{
        public A convert(){
            return null;
        }

        protected static B b = null;
    
        public Iterator<A> iterator(){
            return new Iterator<A>(){
                public boolean hasNext(){
                    return false;
    
                }
    
                public A next(){
                    return null;
                }
            };
        }
    
        B(){
    
        }
    
        B(int n){
    
        }
    
        public static Iterable g(Object b){
            return null;
        }
    
    }