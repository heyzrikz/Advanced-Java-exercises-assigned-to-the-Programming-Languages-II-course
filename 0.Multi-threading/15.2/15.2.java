import java.util.LinkedList;
import java.util.List;

//la soluzione migliore è la (f) poichè prende il mutex solo dell'oggetto Employee che deve modificare, permettendo a più thread di aggiornare la lista in parallelo senza rischiare di modificare concorrentemente lo stesso oggetto Employee
//, infatti se due threads proveranno a modificare lo stesso oggetto employee uno dei due thread verrà bloccato dal synchronyzed

class AgeBonus extends Thread {
    private static List<Employee> list = new LinkedList<>();
    private final int threshold;
    public AgeBonus(int n) { this.threshold = n; }
    @Override
    public void run() {
        synchronized(list){//_____1_____
    for (Employee e: list ) {
        //_____2_____
    System.out.println(Thread.currentThread().getName()+" prendo il mutex "+e.toString());
    if (e.getYears() > threshold)
    e. setSalary(e.getSalary() + 100);
    System.out.println(Thread.currentThread().getName()+" rilascio il mutex "+e.toString());
        //_____3_____
    }
}//_____4_____
    }

    public static void main(String[] args) throws InterruptedException {
        list.add(new Employee(100, 5));
        list.add(new Employee(200, 10));
        list.add(new Employee(300, 15));
        AgeBonus a = new AgeBonus(2);
        AgeBonus b = new AgeBonus(3);
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(list);
        
    }

    }

    class Employee{
        public int salary;
        public int years;
        public Employee(int s , int y){
            salary = s;
            years = y;
        }
        public int getSalary(){
            return salary;
        }

        public void setSalary(int s){
            salary = s;
        }

        public int getYears(){
            return years;
        }

        public String toString(){
            return ""+years+" "+salary;
        }
    }
    