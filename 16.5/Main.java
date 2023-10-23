import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Integer [] a = { 1, 2, 45, 56, 343, 22, 12, 7, 56};
        List<Integer> l = Arrays.asList(a);
        Selector<Integer> pari = new Selector<Integer>() {
        public boolean select(Integer n) {
        return (n % 2) == 0;
        }
        };
        for (Integer n: new SelectorIterator<Integer>(l, pari))
        System.out.print(n + " ");
        



    }
    
}
