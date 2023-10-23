import java.util.ArrayList;
import java.util.List;

public class Library{
    private List<Book> biblioteca;
    private List<Book> prestati;
    private int data;
    Library(){
        biblioteca = new ArrayList<Book>();
        prestati = new ArrayList<Book>();
        data = 0;
    }

    public boolean addBook(Book b){
        if(biblioteca.contains(b)) return false;
        biblioteca.add(b);
        return true;
    }

    public boolean loanBook(Book b){
        if(! biblioteca.contains(b)) throw new IllegalArgumentException();
        if(prestati.contains(b)) return false;
        else{
            prestati.add(b);
            return true;
        }
    }

    public boolean returnBook(Book b){
        if(! biblioteca.contains(b)) throw new IllegalArgumentException();
        if(! prestati.contains(b)) throw new IllegalArgumentException();
        else{
            prestati.remove(b);
            return true;
        }
    }

    public void printLoans(){
        for(Book b : prestati){
        System.out.println(b);
        }

    }



}