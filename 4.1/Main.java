public class Main {
    public static void main(String args[]){
        Product sedia = new Product("Sedia␣elegante", 100);
    Product tavolo = new Product("Tavolo␣di␣cristallo", 200);
    Cart cart = new Cart();
    cart.add(sedia);
    cart.add(tavolo);
    cart.add(sedia);
    System.out.println(cart. totalPrice ());
    cart.remove(sedia);
    System.out.println(cart. totalPrice ());
    Product sedia2 = new Product("Sedia␣elegante", 150);


    }
    
}
