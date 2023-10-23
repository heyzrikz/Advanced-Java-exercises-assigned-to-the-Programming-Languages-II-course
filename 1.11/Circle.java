public class Circle extends Shape{
    protected double x_centro;
    protected double y_centro;
    protected double raggio;

    Circle(double x , double y , double r){
        super(x,y,r);
        x_centro = x;
        y_centro = y;
        raggio = r;
    }

    public void setRadius(double r){
        raggio = r;
        x = x_centro - raggio;
        y = y_centro - raggio;
        w = raggio + raggio;
        h = raggio + raggio;
    }

    public boolean equals(Object o){
        if(!(getClass() == o.getClass())) return false;
        Circle c = (Circle) o;
        return c.x_centro == x_centro && c.y_centro == y_centro && c.raggio == raggio;
    }

}