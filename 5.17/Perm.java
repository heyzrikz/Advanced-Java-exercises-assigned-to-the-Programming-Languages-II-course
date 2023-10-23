import java.util.LinkedList;
import java.util.List;

/*
a)è funzionale,completa,corretta,fornisce ulteriori garanzie, semplicità massima
b)è funzionale,completa,corretta,non fornisce ulteriori garanzie,poco semplice
c)non è completa
d)non è completa
e)non è completa accetta solo List di object
f)non è completa non è detto che le due liste debbano essere presenti nella stessa gerarchia
*/
public class Perm{
static boolean arePermutations(List<?> a ,List<?> b){
    if(a.size() != b.size()) return false;
    for(Object o : a){
        if(! b.contains(o)) return false;
    }
    return true;
}
public static void main(String arg[]){
    List<B> a = new LinkedList<>();
    List<A> b = new LinkedList<>();
    a.add(new B("ciao"));
    a.add(new B("bello"));
    b.add(new A("bello"));
    b.add(new A("ciao"));
    System.out.println(Perm.arePermutations(a,b));
}
}

class A{
    protected String val;
    A(String v){
        val = v;
    }
public boolean equals(Object o){
    if(!(o instanceof A)) return false;
    A a = (A) o;
    return a.val.equals(val);
}
}

class B extends A{
B(String v){
super(v);
}
}