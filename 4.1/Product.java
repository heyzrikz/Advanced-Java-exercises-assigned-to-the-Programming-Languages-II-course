import java.util.ArrayList;
import java.util.List;

public class Product{
    private String descrizione;
    private double prezzo;
    private static List<String> elenco_descrizioni = new ArrayList<>();

    Product(String d , double p){
        if(elenco_descrizioni.contains(d)) throw new Error();
        descrizione = d;
        prezzo = p;
        elenco_descrizioni.add(descrizione);
    }

    public double getPrezzo(){
        return prezzo;
    }

    public boolean equals(Object o){
        if(!(getClass() == o.getClass())) return false;
        Product p = (Product) o;
        return (descrizione.equals(p.descrizione)) && (prezzo == p.prezzo);
    }


}