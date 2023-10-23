import java.util.Set;
import java.util.TreeSet;
public class Room{
    private Set<Reservation> prenotazioni;
    Room(){
        prenotazioni = new TreeSet<Reservation>();
    } 

    public Reservation reserve(String nome , int inizio, int fine){
        for(Reservation r: prenotazioni){
            if(r.occupata(inizio,fine)) throw new Error();
        }
        Reservation re = new Reservation(nome,inizio,fine);
        prenotazioni.add(re);
        return re;
    }

    public Set<Reservation> reservations(){
        return prenotazioni;
    }

   


}