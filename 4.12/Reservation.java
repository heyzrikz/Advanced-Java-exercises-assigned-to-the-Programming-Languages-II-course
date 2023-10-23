public class Reservation implements Comparable{
    private String nome;
    public int inizio;
    private int fine;

    public String getName(){
        return nome;
    }

    Reservation(String n , int i , int f){
        nome = n;
        inizio = i;
        fine = f;
    }

    public boolean occupata(int i , int f){
        if(i >= fine || f <= inizio) return false;
        return true;
    }

    public int compareTo(Object o){
        if(!(getClass() == o.getClass())) throw new IllegalArgumentException();
        Reservation r = (Reservation) o;
        if(inizio < r.inizio) return -1;
        if(inizio > r.inizio) return 1;
        return 0;
    }

}