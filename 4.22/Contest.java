import java.util.HashMap;
import java.util.Map;

public class Contest<T>{
    Map<T,Integer> concorso = new HashMap<>();
    T capolista = null;
    int punteggio_massimo = 0;

    public void add(T partecipante){
        concorso.put(partecipante,0); // O (1)
        if(0 >= punteggio_massimo) capolista = partecipante;
    }

    public void vote(T partecipante){
        if(concorso.get(partecipante) == null) throw new RuntimeException(); //O(1)
            concorso.put(partecipante,concorso.get(partecipante) + 1); //O(1)
        if(concorso.get(partecipante) >= punteggio_massimo){ //O(1)
            punteggio_massimo = concorso.get(partecipante); //O(1)
            capolista = partecipante;
        }
    }

    public T winner(){
        return capolista;
    }
}