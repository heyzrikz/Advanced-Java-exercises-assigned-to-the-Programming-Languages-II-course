public class Range<T extends Comparable<T>>{
    private T min;
    private T max;
    Range(T a , T b){
        min = a;
        max = b;
    }
    Range(){
        min = null;
        max = null;
    }

    public boolean isInside(T a){
        if(a.compareTo(min) >= 0 && a.compareTo(max) <= 0) return true;
        else return false;
    }

    public boolean isOverlapping(Range<T> r){
        if(r.min.compareTo(max) > 0 || r.max.compareTo(min) < 0) return false;
        else return true;
    }

    public boolean equals(Object o){
        if(!(o instanceof Range)) return false;
            Range<T> r = (Range<T>) o;
            if(r.min.getClass() != min.getClass()) return false;
            return (r.min.equals(min) && r.max.equals(max));

    }
}