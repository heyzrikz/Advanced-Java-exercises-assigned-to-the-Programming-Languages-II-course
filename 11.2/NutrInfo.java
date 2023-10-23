import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NutrInfo implements Comparable<NutrInfo>{
    private int chilocalorie;
    private Map<Nutrient,Double> valori;
    NutrInfo(int c){
        chilocalorie = c;
        valori = new HashMap<Nutrient, Double>();
        valori.put(Nutrient.FAT,0.0);
        valori.put(Nutrient.CARBO,0.0);
        valori.put(Nutrient.PROTEIN,0.0);

    }

    public void setNutrient(Nutrient n,Double g){
        valori.put(n,g);
    }
    
    public int compareTo(NutrInfo n){
        if(chilocalorie > n.chilocalorie) return 1;
        if(chilocalorie < n.chilocalorie) return -1;
        return 0;
    }

    public static Comparator<NutrInfo> comparatorBy(Nutrient n){
        return new Comparator<NutrInfo>(){
            public int compare(NutrInfo n1 , NutrInfo n2){
                Double d1 = n1.valori.get(n);
                Double d2 = n2.valori.get(n);
                return d1.compareTo(d2);
            }
        };
    }

}