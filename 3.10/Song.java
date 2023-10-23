public class Song{
    private String nome;
    private int durata;
    Song(String n , int d){
        nome = n;
        durata = d;
    }

    public int getDurata(){
        return durata;
    }

    public boolean equals(Object o){
        if(!(o.getClass() == getClass())) return false;
        Song s = (Song) o;
        return nome.equals(s.nome) && durata == s.durata;
    }
}