public class Test {
    public static void main(String[] args) {
    C gamma = new C();
    B beta = gamma;
    A alfa = gamma;
    System.out.println( alfa . f (beta, gamma, gamma));
    System.out.println(beta. f (beta, beta, beta));
    System.out.println(gamma.f(alfa, null, beta));
    }
    }