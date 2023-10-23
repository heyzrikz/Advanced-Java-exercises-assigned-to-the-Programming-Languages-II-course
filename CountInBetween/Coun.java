import java.util.Comparator;

public class Coun{
    public static <T,E extends T> int countInBetween(T[] arr , Comparator<? super T> c , E a , E b){
        int count = 0;
        for(T t : arr){
            if(c.compare(t,a) > 0 && c.compare(t,b) < 0) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Number[] arr = new Number[]{0,1,2,3,4,5,6,7,8,9};
        Comparator<Number> c = new Comparator<Number>(){
            public int compare(Number a , Number b){
                if(a.doubleValue() > b.doubleValue()) return 1;
                if(a.doubleValue() < b.doubleValue()) return -1;
                return 0;
            }
        };
        Integer a = new Integer(6);
        Integer b = new Integer(3);
        System.out.println(Coun.countInBetween(arr, c, a, b));

    }
}