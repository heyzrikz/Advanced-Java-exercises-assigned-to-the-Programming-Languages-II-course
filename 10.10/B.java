public class B extends A{

    B(){
        super(3);

    }

    B(int i){
        super(i);

    }
    public static class C extends B{
        C(int i){

        }
    }

    public void g(B b , int n){
    }

    public static class D extends B{
        D(int i){
            
        }
    }



}