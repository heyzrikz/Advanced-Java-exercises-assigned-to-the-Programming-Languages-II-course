class A {
    public String f(Object a, A b) { return "A1"; }
    public String f(A a, B b) { return "A2"; }
    }
    class B extends A {
    public String f(B a, B b) { return "B1␣+␣" + f(a, (A)b); }
    public String f(A a, B b) { return "B2"; }
    }
    
    //B1+A1
    //B1+A1
    //B2