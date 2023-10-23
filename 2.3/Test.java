import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List l = new LinkedList<Number>();
        C gamma = new C();
        B beta = gamma;
        A alfa = gamma;
        System.out.println( alfa . f (beta, gamma));
        System.out.println(beta. f (beta, beta));
        System.out.println(gamma.f(alfa, null));
        System.out.println(beta instanceof A);
        } 
}

//A3
//C2
//C2
//true
