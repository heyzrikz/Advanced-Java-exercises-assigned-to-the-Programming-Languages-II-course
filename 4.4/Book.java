public class Book{
    private String titolo;
    Book(String t){
        titolo = t;
    }

    public boolean equals(Object o){
        if(!(o instanceof Book)) return false;
        Book b = (Book) o;
        return titolo.equals(b.titolo);
    }

    public String toString(){
        return titolo;
    }
}