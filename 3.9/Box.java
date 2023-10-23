public class Box implements Comparable{
    private int altezza;
    private int larghezza;
    private int profondita;

    Box(int a, int l , int p){
        altezza = a;
        larghezza = l;
        profondita = p;
    }
    public boolean equals(Object o){
        if(!(getClass() == o.getClass())) return false;
        Box b = (Box) o;
        return (altezza == b.altezza) && (larghezza == b.larghezza) && (profondita == b.profondita);
    }

    public int compareTo(Object o){
        if(!(getClass() == o.getClass())) throw new IllegalArgumentException();
        Box b = (Box) o;
        int volume = larghezza*profondita*altezza;
        int volume_b = b.larghezza*b.profondita*b.altezza;
        if(volume > volume_b) return 1;
        if(volume < volume_b) return -1;
        return 0;

    }

    public boolean fitsIn(Box x){
        if(compareTo(x) >= 0) return true;
        else return false;
    }



}