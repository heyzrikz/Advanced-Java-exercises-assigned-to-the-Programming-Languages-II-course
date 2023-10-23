public class Pair<S,I>{
    private S first;
    private I second;

    Pair(S f , I s){
        first = f;
        second = s;
    }

    public boolean equals(Object o){
        if(!(getClass() == o.getClass())) return false;
        Pair p = (Pair) o;
        return p.first.equals(first) && p.second.equals(second);

    }

    public int hashCode(){
        return first.hashCode() ^ second.hashCode();
    }

    public String toString(){
        return "("+first.toString()+","+second.toString()+")";
    }


}