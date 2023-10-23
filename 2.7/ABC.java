class A {
    public String f (Object x, A y) { return "A1"; }
    private String f (A x, Object y) { return "A2"; }
    protected String f(A x, B y) { return "A3"; }
    }
    class B extends A {
    public String f(B x, B y) { return "B1␣+␣" + f(x, (Object)y); }
    public String f(A x, Object y) { return "B2"; }
    }
    class C extends B {
    public String f(A x, Object y) { return "C1␣+␣" + f(x, (B)y); }
    public String f(Object x, A y) { return "C2"; }
    }
    
    //B1+B2
    //B1+B2
    //ERRORE
