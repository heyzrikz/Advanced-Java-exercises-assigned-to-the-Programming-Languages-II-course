public class B {
    B(){

    }

    B(boolean b){

    }

    public class C extends B{
        C(boolean c){

        }

        C(int i){
            
        }
    }

    public B f(Object o){
        return this;
    }

    public B clone(){
        return this;
    }

}