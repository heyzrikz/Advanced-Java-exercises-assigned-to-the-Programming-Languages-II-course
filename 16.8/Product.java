import java.util.ArrayList;
import java.util.Comparator;

public class Product implements Comparable{
    private String nome;
    private double prezzo;
    private static ArrayList<Product> list = new ArrayList<>();
    
    Product(String n , double p){
        nome = n;
        prezzo = p;
        list.add(this);
    }
    
    public static Product getMostExpensive(){
        double max = 0;
        Product prod = null;
        for(Product p : list){
            if(p.prezzo > max){max = p.prezzo ; prod = p;}
        }
        return prod;
    }

    public String toString(){
        return nome+" , "+prezzo;
    }

    public static Comparator<Product> comparatorByPrice = new Comparator<Product>(){
        public int compare(Product a, Product b){
            if(a.prezzo < b.prezzo) return -1;
            if(a.prezzo> b.prezzo) return 1;
            if(a.prezzo == b.prezzo) return 0; 
            return 0;
        }
    };

    public int compareTo(Object o){
        if(getClass() != o.getClass()) throw new IllegalArgumentException();
        Product p = (Product) o;
        if(prezzo > p.prezzo) return -1;
        if(prezzo < p.prezzo) return 1;
        if(prezzo == p.prezzo) return 0;
        return 0;
    }

}