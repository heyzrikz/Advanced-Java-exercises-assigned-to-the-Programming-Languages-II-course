import java.util.Map;

public class Errors {
     private static int num = 7;
     private static Integer z = 8;
     private static boolean ciao(){
          int c = z;
          return true;
     }
     Map<Integer, Errors> m = new Map<Integer, Errors>();
    
     public Errors() { super();}
    
     private class A {
     private A() { num += z; }
     }
     private void f() {
           m.put(7, new Errors() { public int g() { return 0;} });
           }
     
           private static int a = 3;
           private int b = a;

           private class D {
               D(int n){

               }
               D(){
                    
               }
                }

                private class F extends D{
               F(int j){

               }
               }
               
    
}

    //B1 + B2
    //B1 + B2
    //B1 + B2
    //TRUE