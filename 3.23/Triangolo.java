public class Triangolo{
    private double base;
    private double cateto1;
    private double cateto2;
    Triangolo(){
    }

    Triangolo(double b ,double c1 ,double c2){
        if(b<(c1+c2) && c1<(b+c2) && c2<(b+c1)){
            base = b;
            cateto1 = c1;
            cateto2 = c2;
        }else throw new RuntimeException("non è un triangolo");
            }
    
    public double getArea(){
        double p = (base + cateto1 + cateto2)/2;
        double area = Math.sqrt((p)*(p-base)*(p-cateto1)*(p-cateto2));
        return area;
    }

    public class Rettangolo extends Triangolo{
        Rettangolo(){

        }

        Rettangolo(int c1,int c2){
            super(Math.sqrt((c1*c1)+(c2*c2)),c1,c2);

        }
    }

    public static class Isoscele extends Triangolo{
        Isoscele(){

        }

        Isoscele(int b,int c1){
            super(b,c1,c1);
        }
    }


}