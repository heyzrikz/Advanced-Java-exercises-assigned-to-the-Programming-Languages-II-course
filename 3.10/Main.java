public class Main {
    public static void main(String arg[]){
        Song one = new Song("One", 275), two = new Song("Two", 362);
        Playlist a = new Playlist(), b = new Playlist();
        a.add(one); a.add(two); a.add(one);
        b.add(one); b.add(two);
        System.out.println(a.compareTo(b));
        a.remove(one);
        System.out.println(a.compareTo(b));  
    }
}
