/*
Possibili outputs:
a)  b)  c)
1   2   1
1   1   2
2   1   1
*/
public class A {
    private volatile int n;
    public int incrementAndGet() {
    return ++n;
    }
    public static void main(String[] args) throws InterruptedException {
    A a = new A(), b = new A();
    Thread t0 = new Thread(() -> System.out.println(Thread.currentThread().getName()+": "+a.incrementAndGet())),
    t1 = new Thread(() -> System.out.println(Thread.currentThread().getName()+": "+b.incrementAndGet())),
    t2 = new Thread(() -> System.out.println(Thread.currentThread().getName()+": "+a.incrementAndGet()));
    t0. start () ;
    t1. start () ; t2. start () ;
    }
    }
    