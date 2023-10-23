class A {
    public String f(A x, A y, B z) { return "A1"; }
    public String f(A x, Object y, A z) { return "A2"; }
    private String f(B x, Object y, B z) { return "A3"; }
    }
    class B extends A {
    public String f(A x, A y, B z) { return "B1" + f(x, this, z); }
    private String f(A x, B y, B z) { return "B2"; }
    public String f(B x, Object y, B z) { return "B3"; }
    }

    //A1
    //A2
    //ERRORE
    //B1 + B2