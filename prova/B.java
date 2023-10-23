import javax.print.attribute.standard.MediaSize.Other;

public class B extends A {
    public B() {
   this(0);
   System.out.println("B()");
    }
    public B(int n) {
   System.out.println("B(int)");
    }
    public static void main(String[] args) {
   new B();
    }
   }

   public boolean equals(Object o){
       if(!(getClass() == o.getClass())) return false;
       Z z = (Z) o;
       return (((other == null && z.other == null) || (other != null && z.other != null)) 
              && (val == z.val)); 
   }