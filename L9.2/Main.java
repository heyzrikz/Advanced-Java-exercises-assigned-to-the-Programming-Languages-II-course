public class Main {
    public static void main(String[] args){
        Time t1 = new Time(14,35,0);
Time t2 = new Time(7,10,30);
Time t3 = t1.minus(t2);
System.out.println(t3);
System.out.println(t3.compareTo(t2));
System.out.println(t3.compareTo(Time.MIDDAY));






    }
    
}
