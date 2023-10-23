import java.util.Iterator;

public class FunnyIterator implements Iterator {
     private String msg = "";
    
     public Object next() {
     if (msg.equals("")) msg = "ah";
     else msg += msg;
     return msg;
     }
    
     public boolean hasNext() { return msg.length() < 5; }
     public void remove() { }
     public void addChar() { msg += "b"; }
    
     public static void main(String[] args) {
     Iterator i = new FunnyIterator();
    
     do {
     System.out.println(i .next());
     } while (i.hasNext());
     }
     }