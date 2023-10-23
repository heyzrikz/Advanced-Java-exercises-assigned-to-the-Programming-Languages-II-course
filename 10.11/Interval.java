public class Interval{
    protected double first = 0;
    protected double last = 0;
    protected boolean left = false;
    protected boolean right = false;

    Interval(){

    }

    Interval(double i , double j , boolean l , boolean r){
        first = i;
        last = j;
        left = l;
        right = r;
    }

    public boolean contains(double i){
        if(first < i && last > i) return true;
        return false;
    }

    public Interval join(Interval i){
        return new Interval(first,i.last,left,i.right);

    }

    public String toString(){
        String s;
        if(left == true) s = "(";
            else s = "[";
        s = s+first+", "+last;
        if(right == true) s = s+")";
            else s = s+"]";
        return s;
    }


    public static class Open extends Interval{
        Open(double i, double j){
            first = i;
            last = j;
            left = true;
            right = true;
        }
    }

    public static class Closed extends Interval{
        Closed(double i, double j){
            first = i;
            last = j;
            left = false;
            right = false;
        }
    }
    
}