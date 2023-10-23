public class A<T extends Cloneable> extends B<T> {
    private Cloneable t, u;
    private B<String> b;
    private int i;
    public A(T x) {
    t = x;
    u = g1();
    b = g2(x);
    i = this.compareTo("ciao");
    }
    public Double f(Object o) {
    Number n = super.f(o);
    if (n instanceof Double) return (Double)n;
    else return null;
    }
    }
    
     class B<T>{
        B(){
    
        }
    public Cloneable g1(){
        return null;
    }
    
    public B<String> g2(T x){
        return null;
    }
    
    public int compareTo(String x){
        return 1;
    }
    
    public Number f(Object o){
        return null;
    }
}
