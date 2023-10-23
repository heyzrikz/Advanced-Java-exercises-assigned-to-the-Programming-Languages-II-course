public class Main {
    public static void main(String[] args){
        Range<Integer> a = new Range<>(10, 20);
System.out.println(a. isInside (10));
System.out.println(a. isInside (50));
Range<String> b = new Range<>("albero", "dirupo"),
c = new Range<>("albero", "dirupo");
System.out.println(b.isOverlapping(c));
System.out.println(b.equals(a)); //equals funziona
//Range<Object> d = new Range<>(); // errore di compilazione
    }
}
