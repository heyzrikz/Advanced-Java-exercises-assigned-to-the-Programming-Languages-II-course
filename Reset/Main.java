public class Main {
    public static void main(String arg[]) throws IllegalArgumentException, IllegalAccessException{
        Classe c = new Classe();
        Reset.reset(c);
        System.out.println(c.a);
    }
}
