 enum LengthUnit{
    CM(0.01),M(1),KM(1000),INCH(0.025),YARD(0.914),MILE(1609);
    private double metri;
    
    private LengthUnit(double m){
        metri = m;
    }

    public double convertTo(LengthUnit u , double x){
        double in_metri = x * this.metri;
        return in_metri/u.metri;
    }
}

class Main {
    public static void main(String arg[]){
        System.out.println(LengthUnit.CM.convertTo(LengthUnit.INCH, 10));
System.out.println(LengthUnit.KM.convertTo(LengthUnit.YARD, 3.5)
);
System.out.println(LengthUnit.MILE.convertTo(LengthUnit.M, 6.2));
    }
}