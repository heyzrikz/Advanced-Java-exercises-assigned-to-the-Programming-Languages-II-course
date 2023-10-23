import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable{
    
    private class Chapter{
        int numero;
        String name;
        String des;
        Chapter(String n, String d,int num){
            name = n;
            des = d;
            numero = num;
        }
    }
    private List<Book.Chapter> capitoli;
    private int n_capitoli = 0;

    Book(){
        capitoli = new ArrayList<Book.Chapter>();
        n_capitoli = 0;
    }

    public void addChapter(String name , String descrizione){
        n_capitoli++;
        capitoli.add(new Chapter(name,descrizione,n_capitoli));

    }

    public String getChapterTitle(int i){
        if(i <= 0) throw new IllegalArgumentException();
        return capitoli.get(i-1).name;
    }

    public String getChapterContent(int i){
        if(i <= 0) throw new IllegalArgumentException();
        return capitoli.get(i-1).des;
    }

    public int compareTo(Object o){
        if(!(o.getClass() == getClass())) throw new IllegalArgumentException();
        Book b = (Book) o;
        if(n_capitoli > b.n_capitoli) return 1;
        if(n_capitoli < b.n_capitoli) return -1;
        return 0;
    }


}