import java.util.ArrayList;
import java.util.List;

//la soluzione migliore è la (f) poichè limita la sincronizzazione alla sola area critica relativa al
//momento in cui threads diversi modificano lo stesso oggetto Employee

class Main{
    private static List<Employee> list;
static class AgeBonus extends Thread {
public void run() {
    //_____1_____
for (Employee e: list ) {
    synchronized (list){//_____2_____
        System.out.println(Thread.currentThread()+": prendo mutex");
        System.out.println(Thread.currentThread()+": modifico "+e);
if (e.getYears()>10)
e. setSalary(e.getSalary()+150);
System.out.println(Thread.currentThread()+": rilascio mutex");
}//_____3_____
}//_____4_____

}
}


static class LowBonus extends Thread {
public void run() {
    //_____1_____
for (Employee e: list ) {
    synchronized (list){//_____2_____
        System.out.println(Thread.currentThread()+": prendo mutex");
        System.out.println(Thread.currentThread()+": modifico "+e);
if (e.getSalary()<1500)
e. setSalary(e.getSalary()+200);
System.out.println(Thread.currentThread()+": rilascio mutex");
}//_____3_____
}
//_____4_____

}
}


    public static void main(String[] args) throws InterruptedException {
        list = new ArrayList<>();
        list.add(new Employee(100, 50));
        list.add(new Employee(200, 30));
        AgeBonus th = new AgeBonus();
        LowBonus t = new LowBonus();
        th.start();
        t.start();
        th.join();
        t.join();
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
