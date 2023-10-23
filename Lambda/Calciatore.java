import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Calciatore{
    private String nome;
    private int goals = 0;

    public Calciatore(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public Integer getGoals(){
        return goals;
    }

    public void scoreAGoal(){
        goals++;
    }

    public String toString(){
        return getNome()+" ha segnato "+getGoals()+" goals";
    }

    public String convert(Integer i){
        return i.toString();
    }

}

class Main{
    public static void main(String[] args) {
        Function<Calciatore,String> f1 = Calciatore::getNome;
        Calciatore callejon = new Calciatore("Callejon");

        System.out.println(f1.apply(callejon));
    
        Consumer<Calciatore> c1 = (a)->System.out.println(f1.apply(a));

        c1.accept(callejon);

        //RICORDA NEI CASI SPECIFICI NON SI USA FUNCTION BENSì CONSUMER/SUPPLAYER
        //NEI CASI GENERICI ES Employee SI PUò USARE TUTTO, RICORDA FUNCTION ACCETTA T E RESTITUISCE U

        Consumer<Calciatore> c2 = Calciatore::scoreAGoal;
        Function<Calciatore,Integer> f2 = Calciatore::getGoals;
        Consumer<Calciatore> c4 = (a)->{System.out.println(a.getNome()+" score a goal"); c2.accept(a);};
        Consumer<Calciatore> c3 = (a)->System.out.println(f2.apply(a));
        Runnable r1 = ()->System.out.println("Partita iniziata");
        Consumer<Calciatore> c5 = (a)->{
            r1.run();
            c3.accept(a);
            c4.accept(a);
            c3.accept(a);
        };
        c5.accept(callejon);
        Function<Calciatore,String> f3 = Calciatore::toString;
        Consumer<Calciatore> c6 = (c)->{System.out.println(f3.apply(c));};
        c6.accept(callejon);

        BiFunction<Calciatore,Integer,String> f4 = Calciatore::convert;
        BiConsumer<Calciatore,Integer> c7 = (c,i)->{System.out.println(f4.apply(c, i));};
        c7.accept(callejon, 3);

        Comparator<Calciatore> co = (ca1,ca2)->{return ca1.getGoals().compareTo(ca2.getGoals());};
        Calciatore zuniga = new Calciatore("Zuniga");
        c2.accept(zuniga);
        c2.accept(zuniga);
        System.out.println(co.compare(callejon, zuniga));
        
        //Esercizio 17.2
        Predicate<Integer> a = (i)->{return i%2==0;};
        System.out.println(a.test(3));

        Predicate<String> b = (s)->{return s.equals("exit");};
        System.out.println(b.test("exit"));
        
        Predicate<SortedSet<Integer>> c = (s)->{if(s.first()< 0 && s.last() > 0) return true;
                                                else return false;};
        SortedSet<Integer> set = new TreeSet<>();
        set.add(3); set.add(-1); set.add(2);
        System.out.println(c.test(set));
    }
}

//a.compare(b) == - b.compare(a) 
//a.compare(b) == 1 && b.compare(c) == 1 => a.compare(c) == 1
//a.compare(b) == 0 => a.compare(c) == b.compare(c)