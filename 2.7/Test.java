public class Test {
    public static void main(String[] args) {
    B beta = new C();
    A alfa = beta;
    System.out.println( alfa . f (beta, null));
    System.out.println(beta. f (beta, beta));
    System.out.println(beta. f ( alfa , (B)null));
    }
    }
    