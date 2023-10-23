import java.util.LinkedList;
import java.util.List;

public class Pizza implements Comparable<Pizza>{
    enum Ingrediente{
        POMODORO{
            public int getCalorie(){
                return 300;
            }
        },MOZZARELLA{
            public int getCalorie(){
                return 200;
            }
        },AGLIO{
            public int getCalorie(){
                return 50;
            }
        };
        public int getCalorie(){
            return 0;
        }
    }

    private List<Ingrediente> ingredienti = new LinkedList<>();
    private int totale = 0;
    public void addIngrediente(Ingrediente i){
        ingredienti.add(i);
        totale = totale + i.getCalorie();
    }

    public Pizza clone(){
        return this;
    }

    public int compareTo(Pizza p){
        if(totale == p.totale) return 0;
        if(totale > p.totale) return 1;
        return -1;
    }

}