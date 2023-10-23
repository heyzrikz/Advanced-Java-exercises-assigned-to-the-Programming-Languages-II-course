public class Test {
    public static void main(String[] args) {
    B beta = new B();
    A alfa = beta;
    System.out.println( alfa . f (beta, null));
    System.out.println(beta. f (beta, beta));
    System.out.println(beta.getClass() == alfa.getClass());
    }
    }

    class B extends A {
        public String f (B x, B y) { return "B1␣+␣" + f(null, (A)y); }
        private String f(A x, B y) { return "B2␣+␣" + f(y, y); }
        }

        class A {
            public String f(Object x, B y) { return "A1"; }
            public String f(B x, B y) { return "A2" + f(x, y); }
            public String f(A x, Object y) { return "A3"; }
            }
            
//B1 A3
//B1 A3
//TRUE