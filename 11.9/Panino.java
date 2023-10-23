import java.util.LinkedList;
import java.util.List;

public class Panino{
    public enum Ingrediente{
        PROSCIUTTO("ripieni"),SALAME("ripieni"),
        SOTTILETTA("formaggi"),MOZZARELLA("formaggi"),
        MAIONESE("salse"),SENAPE("salse");

        private String categoria;

        Ingrediente(String c){
            this.categoria = c;
        }

        private String getCategoria(){
            return categoria;
        }

        public String toString(){
            return this.name();
        }
    }
   
    private List<Panino.Ingrediente> ingredienti;
    Panino(){
        ingredienti = new LinkedList<Panino.Ingrediente>();
        }

    public void addIngrediente(Panino.Ingrediente p){
        for(Panino.Ingrediente i : ingredienti){
            if(i.getCategoria().equals(p.getCategoria())) throw new RuntimeException();
        }
        ingredienti.add(p);
        }

    public String toString(){
        return "Panino con: "+ingredienti.toString();
    }


}

class Main{
    public static void main(String arg[]){
        Panino p = new Panino();
    p.addIngrediente(Panino.Ingrediente.SALAME);
    p.addIngrediente(Panino.Ingrediente.SOTTILETTA);
    System.out.println(p);
    p.addIngrediente(Panino.Ingrediente.MOZZARELLA);
    }
}