public class Main {
    public static void main(String arg[]){
        WeightedSet<Object> set = new BasicWeightedSet<>();
        set.add(new Object(), 100);
        set.add("ciao",50);
        set.add("ok",70);
        set.add(Double.valueOf(3.14),50);
        System.out.println(set);
        WeightedSet<Object> set60 = set.atLeast(60); 
        System.out.println(set);
        set60.add("obj", 70);
        System.out.println(set60);
        set60.add("o", 50);

    }
}
