import java.util.HashSet;
import java.util.Set;

public class Cellphone{
    private String gestore;
    private String numero;
    private static Set<Chiamata> costi = new HashSet<>();

    private static class Chiamata{
        private String entrante;
        private String uscente;
        private double costo;
        Chiamata(String e ,String u , double c){
            entrante = e;
            uscente = u;
            costo = c;
        }

        public double getCosto(){
            return costo;
        }

        public boolean equals(Object o){
            if(!(getClass() == o.getClass())) return false;
            Chiamata c = (Chiamata) o;
            return entrante.equals(c.entrante) && uscente.equals(c.uscente);
        }

        public int hashCode(){
            return entrante.hashCode() ^ uscente.hashCode();
        }

        public String toString(){
            return entrante+" - "+uscente+" - "+costo;
        }
    }

    Cellphone(String g , String n){
        gestore = g;
        numero = n;
    }

    public static void setCost(String e, String u , double c){
        costi.add(new Chiamata(e,u,c));
    }

    public double getCost(Cellphone c , int min){
        for(Chiamata ch : costi){
            if(ch.entrante == gestore && ch.uscente == c.gestore){
                return ch.getCosto() * min;
            }
        }
        throw new Error();
    }

    public static void printAll(){
        for(Chiamata c:costi){
            System.out.println(c);
        }
    }


}