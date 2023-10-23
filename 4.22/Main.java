public class Main {
    public static void main(String arg[]){
        Contest<String> c = new Contest<String>();
String r = "Red", b = "Blue", g = "Green";
c.add(r);
c.vote(r);
c.add(b);
c.add(g);
c.vote(r);
c.vote(b);
c.vote(b);
c.vote(b);
c.vote(b);

System.out.println(c.winner());
    }
}
