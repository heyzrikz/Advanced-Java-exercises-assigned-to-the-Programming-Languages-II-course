import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class A
{
public static <S,T extends S> void f(Set<S> set1, Set<T> set2)
{
B.process(set1, set2);
B.process(set2, set1);
B<S> b = new B<S>();
S choice1 = b.select (set1),
choice2 = b.select (set2);
Collection<? extends S> c = b.filter(set1);
HashSet<? super S> hs = b.filter(set1);
}
}

 class B<S>{

    public static void process(Set<?> s1 , Set<?> s2){

    }

    B(){

    }

    public S select(Set<?> s1){
        return null;
    }

    public HashSet<S> filter(Set<?> set1){
        return null;
    }

}