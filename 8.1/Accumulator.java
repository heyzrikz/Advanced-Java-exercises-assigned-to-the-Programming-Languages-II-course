import java.util.ArrayList;
import java.util.List;

public class Accumulator<T extends Number>{
    private List<T> positivi;
    private List<T> negativi;
    private double sum;

    Accumulator(){
        positivi = new ArrayList<T>();
        negativi = new ArrayList<T>();
        sum = 0;
    }

    public void add(T n){
        if(n.doubleValue() >= 0) positivi.add(n);
        else negativi.add(n);
        sum = sum + n.doubleValue();
    }

    public List<T> positives(){
        return positivi;
    }

    public List<T> negatives(){
        return negativi;
    }

    public double sum(){
        return sum;
    }
}