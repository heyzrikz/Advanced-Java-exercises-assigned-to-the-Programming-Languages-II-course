import java.util.HashSet;

public class City{
    
    private HashSet<City> collegamenti = new HashSet<>();

    private String name;
    private boolean check = true;

    City(String n){
        name = n;
    }

    public void connect(City c){
        collegamenti.add(c);
        c.accettaConnessione(this);
    }

    private void accettaConnessione(City c){
        collegamenti.add(c);
    }

    public HashSet<City> getConnections(){
        return collegamenti;
    }

    public boolean isConnected(City c){
        if(check == false) return false;
        check = false;
        for(City i: collegamenti){
            if(i.check == true && (i.equals(c) || i.isConnected(c))){
                check = true;
                return true;}
        }
        check = true;
        return false;
    }

    public boolean equals(Object o){
        if(getClass() != o.getClass()) return false;
        City c = (City) o;
            return name.equals(c.name);
    }

    public String toString(){
        return name;
    }
    
}