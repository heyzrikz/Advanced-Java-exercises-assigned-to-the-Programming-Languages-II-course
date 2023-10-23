public class Main {
    public static void main(String[] args){
        Triangolo x = new Triangolo(10,20,25);
        Triangolo y = x.new Rettangolo(5,8);
        Triangolo z = new Triangolo.Isoscele(6,5);
        System.out.println(x.getArea());
        System.out.println(y.getArea());
        System.out.println(z.getArea());
    
    }

}
