public class Main {
    public static void main(String[] args) {
        C c = new C();
        A a = c;
        B b = c;
        b.f(a,a);
    }
}
