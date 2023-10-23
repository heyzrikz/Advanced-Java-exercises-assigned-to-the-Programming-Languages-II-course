public abstract class Shape implements Comparable<Shape>{
    protected double w;
    protected double h;
    protected double x;
    protected double y;

    Shape(double centro_x , double centro_y , double raggio){
        x = centro_x - raggio;
        y = centro_y - raggio;
        w = raggio + raggio;
        h = raggio + raggio;
    }

    public double width(){
        return w;
    }

    public double height(){
        return h;
    }

    public double posX(){
        return x;
    }

    public double posY(){
        return y;
    }

    public int compareTo(Shape s){
        if(!(s.getClass() == getClass())) throw new IllegalArgumentException();
        if(w * h > s.w * s.h) return 1;
        if(w * h < s.w * s.h) return -1;
        return 0;
    }


}