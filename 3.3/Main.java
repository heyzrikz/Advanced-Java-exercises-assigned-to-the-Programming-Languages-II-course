public class Main {
    public static void main(String[] args) {
        Person aldo = new Person("Aldo"), barbara = new Person("Barbara");
GreenPass p1 = aldo.vaccinate(10), p2 = aldo.vaccinate(250);
System.out.println(p1.isValidOn(20));
System.out.println(p1.isValidOn(200));
System.out.println(p1.belongsTo(barbara));
    }
}

