class A {
    public String f(A x, A[] y) { return "A1"; }
    public String f(A x, Object y) { return "A2:" + x.f(new C(), y); }
    }
class B extends A {
    public String f(C x, A[] y) { return "B1:" + x.f((A)x, y); }
    public String f(A x, A[] y) { return "B2"; }
    public String f(A x, Object[] y) { return "B3"; }
    }
class C extends B {
    public String f(A x, B[] y) { return "C1"; }
    }

    //B1 + B2
    //C1
    //B2