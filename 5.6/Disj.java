import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
a)non è completa poichè Collection accetta solo lo stesso tipo
b)non è funzionale poichè ho bisogno dell'accesso in scrittura e lettura delle collections
c)completa, corretta, funzionale, non è tanto semplice ha 2 parametri, offre garanzie sul tipo di ritorno
d)incompleta poichè deve accettare Collection
e)non è funzionale poichè non permette l'accesso in scrittura delle collezioni

mia soluzione:
*/


public class Disj {
    static <S,T> Set<? super S> disjoin(Collection<S> a , Collection<T> b){
        HashSet<S> a1 = new HashSet<>(a);
        HashSet<T> b1 = new HashSet<>(b);
        Set<? super S> ret = new HashSet<>();
        for(S i : a1){
            for(T j : b1){
                if(i.equals(j)){
                    ret.add(i);
                }
            }
        }

        for(Object o : ret){
            a1.remove(o);
            b1.remove(o);
        }
        return ret;
    }
    public static void main(String arg[]){
        ArrayList<C> a = new ArrayList<>();
        ArrayList<B> b = new ArrayList<>();
        a.add(new C(1));
        a.add(new C(2));
        b.add(new B(1));
        b.add(new B(2));
        Set<? super C> set = Disj.disjoin(a, b);
        System.out.println(set);
    }
}

class A{
protected int val;
A(){
    val = 0;
}
A(int v){
    val = v;
}

public boolean equals(Object o){
    if(!(o instanceof A)) return false;
    A a = (A) o;
    return val == a.val;
}

public String toString(){
    return ""+val;
}

}

class B extends A{
B(int v){
    val = v;
}
}

class C extends A{
    C(int v){
        val = v;
    }
}

class D {
    public int val;
    D(int v){
        val = v;
    }
}




//verifica modifica con null per <? extends T>