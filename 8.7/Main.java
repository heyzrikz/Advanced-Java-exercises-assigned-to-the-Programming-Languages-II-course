public class Main {
    public static void main(String arg[]){
        Pair<String,Integer> p1 = new Pair<String,Integer>("uno", 1);
        Pair<String,Integer> p2 = new Pair<>("uno", 1);
    System.out.println(p1);
    System.out.println(p1.equals(p2));

    }
}
