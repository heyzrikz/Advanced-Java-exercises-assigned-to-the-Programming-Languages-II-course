public class Main {
    public static void main(String arg[]){
        Progression a = new Progression(1000, 150);
a.addEmployee("Jesse", 2008);
a.addEmployee("Gale", 2009);
a.addBonus("Gale", 2010, 300);
System.out.println(a.getSalary("Jesse", 2009));
System.out.println(a.getSalary("Gale", 2010));
System.out.println(a.getSalary("Gale", 2011));
    }
}
