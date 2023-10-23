public class Main {
    public static void main(String arg[]){
        Shape c1 = new Circle(2.0, 3.0, 1.0) ;
Shape c2 = new Circle(2.0, 3.0, 1.0) ;
System.out.println(c1.posX() + ",␣" + c1.posY());
System.out.println(c1.width() + ",␣" + c1.height());
System.out.println(c1.equals(c2));
(( Circle ) c2).setRadius(2.0);
System.out.println(c2.posX() + ",␣" + c2.posY());


    }
}
