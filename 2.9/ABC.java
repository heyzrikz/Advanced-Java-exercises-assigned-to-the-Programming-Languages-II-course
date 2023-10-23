class A {
    public String f(Object x, A y, B z) { return "A1"; }
    public String f(A x, C y, C z) { return "A2"; }
    }
    class B extends A {
    public String f (Object x, A y, A z) { return "B1␣+␣" + f(null, new B(), y); }
    private String f(A x, B y, B z) { return "B2"; }
    }
    class C extends B {
    public String f(A x, A y, B z) { return "C1"; }
    public String f(A x, C y, C z) { return "C2"; }
    }
    
    //C2
    //A1
    //B2