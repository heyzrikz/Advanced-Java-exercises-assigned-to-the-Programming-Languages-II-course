 class A {
    public void f(A b){
        System.out.println("A");
    }
    public void f(){
        System.out.println("A");
    }
}

 class B extends A{
    public void f(A b,A c){
        System.out.println("B");
    }
    public void f(){
        System.out.println("B");
    }

}

class C extends B{
    public void f(A c, A b){
        System.out.println("C");
    }

}
