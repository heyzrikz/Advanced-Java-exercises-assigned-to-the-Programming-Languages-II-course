import java.util.LinkedList;
import java.util.List;

/*
contratto: il metodo arePermutations accetta due liste anche di tipi non confrontabili (in quel caso restituisce false)
           e controlla se contengono gli stessi elementi anche in ordine diverso

a) funzionale, completa, corretta, offre garanzie massime sulle liste, semplicità massima
b) funzionale, completa, corretta, non offre garanzie,semplicità: 2
c) funzionale, non completa poichè accetta solo liste dello stesso tipo S
d) funzionale, non completa poichè accetta solo liste che si trovano nella stessa gerarchia
e) funzionale, non completa poichè accetta solo liste di Object
f) funzionale, non completa poichè accetta solo liste che si trovano nella stessa gerarchia

*/
class Perutations{
    public static boolean arePermutations(List<?> a , List<?> b){
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
        System.out.println(arePermutations(a,b));

        List<Integer> c = new LinkedList<>();
        List<String> d = new LinkedList<>();
        c.add(1);
        c.add(2);
        d.add("uno");
        d.add("due");
        System.out.println(arePermutations(c,d));

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