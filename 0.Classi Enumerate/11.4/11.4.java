import java.util.ArrayList;
import java.util.List;

class Pizza implements Comparable<Pizza>{
        private int calorie_totali = 0;
    enum Ingrediente{
        POMODORO(100),MOZZARELLA(200),AGLIO(50);
        private int calorie;
        private Ingrediente(int c){
            calorie = c;
        }

        public int getCalorie(){
            return calorie;
        }
    }

    private List<Ingrediente> pizza = new ArrayList<>();

    public void addIngrediente(Ingrediente i){
        pizza.add(i);
        calorie_totali = calorie_totali + i.getCalorie();
    }

    public int compareTo(Pizza p){
        if(this.calorie_totali > p.calorie_totali) return 1;
        if(this.calorie_totali < p.calorie_totali) return -1;
        return 0;
    }

}

class Main {
    public static void main(String arg[]){
        Pizza margherita = new Pizza(), marinara = new Pizza();
margherita.addIngrediente(Pizza.Ingrediente.POMODORO);
margherita.addIngrediente(Pizza.Ingrediente.MOZZARELLA);
marinara.addIngrediente(Pizza.Ingrediente.POMODORO);
marinara.addIngrediente(Pizza.Ingrediente.AGLIO);
System.out.println( margherita .compareTo(marinara));
    }
}