public class Main {
    public static void main(String[] x) {
        Average a = new Average();
        double d;
        a.add(10);
        a.add(20);
        d = a.getAverage();
        System.out.println("Media␣corrente:␣" + d);
        a.add(60);
        d = a.getAverage();
        System.out.println("Media␣corrente:␣" + d);
        }
        
}
