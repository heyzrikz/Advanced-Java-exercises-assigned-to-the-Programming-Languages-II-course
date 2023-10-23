import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Movie{

    private String titolo;
    private int anno;
    private Movie sequel;
    private Movie serie;
    private static final Map<Integer,HashSet<Movie>> year = new HashMap<>();
    Movie(String t , int a){
        titolo = t;
        anno = a;
        sequel = null;
        serie = this;
        if(year.get(a) != null){
            year.get(a).add(this);
        }else {
            HashSet<Movie> tmp = new HashSet<>();
            tmp.add(this);
            year.put(a,tmp);
        }
    }

    Movie(String t , int a , Movie m){
        titolo = t;
        anno = a;
        m.sequel = this;
        serie = m.serie;
        if(year.get(a) != null){
            year.get(a).add(this);
        }else {
            HashSet<Movie> tmp = new HashSet<>();
            tmp.add(this);
            year.put(a,tmp);
        }
    }

    public LinkedList<Movie> getSeries(){
        LinkedList<Movie> l = new LinkedList<>();
        Movie s = serie;
        while(s != null){
            l.add(s);
            s = s.sequel;
        }
        return l;
    }

    public static Set<Movie> selectByYear(int a){
        return year.get(a);
    }

    public String toString(){
        return titolo;
    }



}