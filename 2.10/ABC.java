class A {
    public String f(Object a, A b) { return "A1"; }
    public String f(A a, C b) { return "A2"; }
    }
    class B extends A {
    public String f (Object a, A b) { return "B1␣+␣" + f(null, new B()); }
    private String f(A a, B b) { return "B2"; }
    }
    class C extends B {
    public String f(Object a, A b) { return "C1"; }
    public String f(A a, B b) { return "C2"; }
    }
    
    //A2
    //C2 forse?
    //A2