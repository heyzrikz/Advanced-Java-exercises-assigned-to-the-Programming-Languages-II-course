public class Main {
    public static void main(String argv[]){
        Room r = new Room();
        Reservation p1 = r.reserve("Pasquale␣Cafiero", 105, 120);
        Reservation p2 = r.reserve("Carlo␣Martello", 5, 20);
        Reservation p3 = r.reserve("Piero", 20, 22);
        Reservation p4 = r.reserve("Marinella", 200, 222);
        for (Reservation p: r. reservations ())
        System.out.println(p.getName());



    }
    
}
