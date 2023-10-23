public class Main {
    public static void main(String[] args){
        Interval i1 = new Interval.Open(5, 10.5);
Interval i2 = new Interval.Closed(7, 20);
Interval i3 = i1. join (i2);
System.out.println(i1 .contains(5));
System.out.println(i1);
System.out.println(i2);
System.out.println(i3);


    }
    
}
