import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> prodotti;
    private double prezzo;
    Cart(){
        prodotti = new ArrayList<Product>();
        prezzo = 0;
    }

    public void add(Product p){
        prezzo = prezzo + p.getPrezzo();
        prodotti.add(p);
    }

    public double totalPrice(){
        return prezzo;
    }

    public void remove(Product p){
        prodotti.remove(p);
        prezzo = prezzo - p.getPrezzo();
    }


}