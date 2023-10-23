import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library{
    
    public static class Book{
    private String titolo;
    private String autore;
    private List<String> tags;
    Book(String t, String a){
        titolo = t;
        autore = a;
        tags = new ArrayList<String>();
        }
    
    public void addTag(String tag){
        tags.add(tag);    
        }

    public String toString(){
        return titolo+", by "+autore;
    }
    }

    private List<Book> elenco;
    
    Library(){
        elenco = new ArrayList<Book>();
        }

    public Book addBook(String t, String a){
        Book b = new Book(t, a);
        elenco.add(b);
        return b;
    }
    
    public Set<Book> getBooksByTag(String tag){
        Set<Book> set = new HashSet<>();
        for(Book b : elenco){
            if(b.tags.contains(tag)) set.add(b);
        }
        return set;
    } 

    

    
}