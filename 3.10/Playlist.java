import java.util.LinkedList;
import java.util.List;

public class Playlist implements Comparable<Playlist>{
    List<Song> playlist;
    private int durata_tot;
    Playlist(){
        playlist = new LinkedList<Song>();
        durata_tot = 0;
    }

    public void add(Song s){
        playlist.add(s);
        durata_tot = durata_tot + s.getDurata();
    }

    public void remove(Song s){
        while(playlist.contains(s)){
            {durata_tot = durata_tot - s.getDurata(); playlist.remove(s);}
        }
    }


    public int compareTo(Playlist p){
        if(p.durata_tot == durata_tot) return 0;
        if(durata_tot > p.durata_tot) return 1;
        return -1;
    }




}