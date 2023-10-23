import java.util.ArrayList;
// a) c) d) e) f) funzionano , ma solo c) e) ed f) garantiscono il mutex sulla collezione e sugli elementi
public class Out{
    public static void main(String arg[]) throws InterruptedException{
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(100, 50));
        list.add(new Employee(200, 30));
        list.add(new Employee(200, 20));
      
        class AgeBonus extends Thread {
            private final int threshold;
            public AgeBonus(int n) { this.threshold = n; }
            @Override
            public void run() {
              //_____1_____
            for (Employee e: list ) {
                synchronized (this){//_____2_____
            if (e.getYears() > threshold)
            e. setSalary(e.getSalary() + 100);
                       }       //_____3_____
            }
          //_____4_____
            }
            }
            AgeBonus a = new AgeBonus(25);
            AgeBonus b = new AgeBonus(40);
            a.start();
            b.start();
            a.join();
            b.join();
            System.out.println(list);
    }


}

    class Employee{
        private int salary;
        private int years;
        
        Employee(int s , int y){
            salary = s;
            years = y;
        }

        public int getYears(){
            return years;
        }

        public int getSalary(){
            return salary;
        }

        public void setSalary(int salary){
            this.salary = salary;
        }

        public String toString(){
            return ""+salary+" - "+years;
        }
    }
    
    //Mattina : Esercizi Thread e Scelta della Firma
    //Pomeriggio : Tirocinio
