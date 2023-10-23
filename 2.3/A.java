class A {
    public String f(Object a, B b) { return "A1"; }
    public String f(A a, A b) { return "A2"; }
    public String f(B a, C b) { return "A3"; }
    }
    class B extends A {
    public String f (Object a, A b) { return "B1␣+␣" + f(null, new B()); }
    private String f(A a, B b) { return "B2"; }
    }
    class C extends B {
    public String f(Object a, B b) { return "C1"; }
    public String f(A a, B b) { return "C2"; } 
    }
    