public class A {
    private B b1 = new B(null);
    private B b2 = new B.C();
    private B b3 = b1.new D();
    private int f(Object x) {
    if (x==null) throw b2;
    long l = b1.g();
    return b1.g();
    }
    }