import java.util.Collection;

public class Main {
    public static void main(String[] args){
    City n = new City("Napoli"), r = new City("Roma"), s = new City
("Salerno"), p = new City("Parigi");
n.connect(s);
n.connect(r);
Collection<City> r_conn = r.getConnections();
System.out.println(r_conn);
System.out.println(r.isConnected(s));
System.out.println(r.isConnected(p));
}
}
