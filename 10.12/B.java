public class B extends Error{
    B(){

    }

    B(Object i){

    }

    public static class C extends B{
        C(){

        }
    }

    public class D extends B{
        D(){

        }
    }

    public int g(){
        return 1;
    }

}