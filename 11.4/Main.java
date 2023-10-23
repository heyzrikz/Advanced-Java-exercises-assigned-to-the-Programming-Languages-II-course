public class Main {
    public static void main(String arg[]){
        Pizza margherita = new Pizza(), marinara = new Pizza();
margherita.addIngrediente(Pizza.Ingrediente.POMODORO);
margherita.addIngrediente(Pizza.Ingrediente.MOZZARELLA);
marinara.addIngrediente(Pizza.Ingrediente.POMODORO);
marinara.addIngrediente(Pizza.Ingrediente.AGLIO);
Pizza altra = margherita.clone();
System.out.println( altra .compareTo(marinara));
    }
}
