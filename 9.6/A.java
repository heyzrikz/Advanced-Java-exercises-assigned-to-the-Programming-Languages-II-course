public class A extends B {
public A() {
b1 = new B.C(true);
b2 = new B(false);
}
public B f(Object o) {
B x = super.f(o);
return x.clone();
}
private B.C c = new B.C(3);
private B b1, b2;
}


class B{
    B(){

    }

    static class C extends B{
        C(Boolean b){

        }

        C(int a){

        }
    }

    B(Boolean n){

    }

    public B f(Object o){
        return null;
    }

    public B clone(){
        return null;
    }




}