public class Main {

    public static void main(String args[]){
        RotatingList<Integer> l = new RotatingList<>();
    l .add(1); l .add(2); l .add(3);
    System.out.println(l );
    l . rotateLeft () ;
    System.out.println(l );
    l .add(4);
    System.out.println(l );
    l .rotateRight();
    System.out.println(l );
    }
    
}
