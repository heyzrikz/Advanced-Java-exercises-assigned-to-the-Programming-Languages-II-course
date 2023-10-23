import java.util.Comparator;

public class Main {
    public static void main(String arg[]){
        NutrInfo x = new NutrInfo(500);
    x.setNutrient(Nutrient.FAT, 12.0);
    x.setNutrient(Nutrient.CARBO, 20.0);
    x.setNutrient(Nutrient.PROTEIN, 15.0);
    Comparator<NutrInfo> c = NutrInfo.comparatorBy(Nutrient.CARBO);

    NutrInfo y = new NutrInfo(200);
    y.setNutrient(Nutrient.FAT, 15.0);
    y.setNutrient(Nutrient.CARBO, 10.0);
    y.setNutrient(Nutrient.PROTEIN, 15.0);

    System.out.println(c.compare(x, y));
    System.out.println(x.compareTo(y));
    }
}
