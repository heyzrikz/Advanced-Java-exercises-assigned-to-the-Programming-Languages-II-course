public class A {
    private B<Integer> b1 = new B<Integer>(null);
    private B<?> b2 = B.f(3);
    private Comparable<? extends Number> c = new B<Double>();
    public Object f() {
    Integer x = b1.getIt();
    Integer y = x + b2.getIt();
    return new B<String>(new A());
    }
    }

    class B<T> implements Comparable<T>{

        B(){

        }

        B(A a){

        }

        public static B f(int a){
            return null;
        }

        public int compareTo(T o){
            return 1;
        }

        public Integer getIt(){
            return null;
        }


    }
    