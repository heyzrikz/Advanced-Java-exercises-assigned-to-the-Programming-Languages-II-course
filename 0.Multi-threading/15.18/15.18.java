//Output: 4 1
//        1 4
//in generale stamperà sicuramente 4 e un numero da 1 a 3 a seconda di quale thread sveglierà il main con la notify
class Main{
public static void main(String[] args) {
    class MyThread extends Thread {
    private int id;
    private Object object;
    public MyThread(int n, Object x) {
    id = n;
    object = x;
    }
    public void run() {
    try {
        System.out.println(Thread.currentThread().getName());
    synchronized (object) {
        System.out.println(Thread.currentThread().getName()+" con valore "+id+" prende mutex");
    object.wait();
    }
    } catch (InterruptedException e) {
    return;
    }
    System.out.println(Thread.currentThread().getName()+" si sveglia");
    System.out.println(id);
    }
    }
    Object o1 = new Object(), o2 = new Object();
    Thread t4 = new MyThread(4,o2);
    Thread t1 = new MyThread(1,o1);
Thread t2 = new MyThread(2,o1);
Thread t3 = new MyThread(3,o1);
t1. start () ; t2. start () ; t3. start () ; t4. start () ;
    try { Thread.sleep(1000); } catch (InterruptedException e) { }
    synchronized (o2) { o2.notifyAll(); }
    synchronized (o1) { o1.notify(); }
    }
}