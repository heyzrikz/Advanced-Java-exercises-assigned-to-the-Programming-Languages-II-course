class A {
public String f(Object x, B y) { return "A1"; }
private String f(B x, B y) { return "A2␣:␣" + f(x, y); }
public String f(A x, Object y) { return "A3"; }
}


