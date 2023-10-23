public class Main {
    public static void main(String[] args){
        Product a = new Product("Sale", 0.60),
        b = new Product("Zucchero", 0.95),
        c = new Product("Caffe’", 2.54);
        System.out.println(Product.getMostExpensive());
        System.out.println(b.compareTo(c));
        System.out.println(Product.comparatorByPrice.compare(b, c));
    
    }
}
