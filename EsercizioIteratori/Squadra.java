import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class Squadra implements Iterable<Calciatore>{
    private Map<Calciatore,Integer> rosa = new HashMap<>();
    public Calciatore calciatore = null;

    public void addCalciatore(Calciatore c , Integer n){
        rosa.put(c,n);
        if(calciatore == null) calciatore = c;
    }

    public Iterator<Calciatore> iterator(){
        return new Iterator<Calciatore>(){
            public boolean hasNext(){
                return calciatore != null;
            }

            public Calciatore next(){
                Calciatore ret = calciatore;
                int min = rosa.get(calciatore);
                Integer max = null;
                calciatore = null;
                for(Calciatore c : rosa.keySet()){
                    if((max == null && rosa.get(c) > min) || ( max != null && rosa.get(c) < max && rosa.get(c) > min)){
                        max = rosa.get(c);
                        calciatore = c;
                    }
                }
                return ret;
            }
        };
    }
}

enum Ruolo{
    PORTIERE,DIFENSORE,CENTROCAMPISTA,ATTACCANTE;
    public String toString(){
        return this.name();
    }
}


class Calciatore{
    private String name;
    private Ruolo ruolo;
    
    public Calciatore(String name, Ruolo ruolo){
        this.name = name;
        this.ruolo = ruolo;
    }

    public String toString(){
        return name+"-"+ruolo.toString();
    }
    
}

class Main{
    public static void main(String[] args) {
        Squadra napoli = new Squadra();
        TriConsumer<Squadra,Calciatore,Integer> addCalciatore = Squadra::addCalciatore;
        addCalciatore.accept(napoli, new Calciatore("Meret",Ruolo.PORTIERE), 1);
        addCalciatore.accept(napoli, new Calciatore("Di Lorenzo",Ruolo.DIFENSORE), 22);
        addCalciatore.accept(napoli, new Calciatore("Rrahmani",Ruolo.DIFENSORE), 3);
        addCalciatore.accept(napoli, new Calciatore("Lobotka",Ruolo.CENTROCAMPISTA), 68);
        Consumer<Squadra> printAll = (s)->{
            for(Calciatore c : s){
                System.out.println(c);
            }
        };
        printAll.accept(napoli);

    }
}