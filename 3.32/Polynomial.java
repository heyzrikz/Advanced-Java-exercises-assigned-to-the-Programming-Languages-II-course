import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polynomial{

    private double coefficienti[];
    private int grado;

    Polynomial(double a[]){
        coefficienti = a;
        grado = a.length - 1;
    }

    public int getDegree(){
        return grado;
    }

    public Polynomial times(Polynomial p){
        double a[] = new double[grado + p.getDegree() + 1];
        for(int i = 0; i < p.coefficienti.length; i++){
            for(int j = 0 ; j < coefficienti.length; j++ ){
                a[i+j] = a[i+j] + (coefficienti[j] * p.coefficienti[i]);
            }
        }
        return new Polynomial(a);
    }

    public String toString(){
        String str = ""; 
        for(int i = 0 ; i < coefficienti.length; i++){
            if(coefficienti[i] >= 0){
                str=str+" + ";
            }
            str = str + coefficienti[i];
            if(i != 0) str = str + " x^"+i+" ";
        }

        return str;
    }


}