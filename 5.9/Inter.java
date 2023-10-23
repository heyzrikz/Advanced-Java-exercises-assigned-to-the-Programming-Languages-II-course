import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
a)non è completa, stesso tipo parametrico per tutte le liste
b)completa,corretta, funzionale, non fornisce ulteriori garanzie, poca semplicità (2 parametri)
c)completa, corretta , funzionale, fornisce garanzie , semplicità, non ha parametri di tipo
d)non funzionale, non possiamo inserire oggetti di tipo Object in una lista di S senza l'uso di cast
e)non completa, stesso tipo parametrico per le prime due liste






*/
public class Inter {
    //QUESTA NON VA BENE
  static void interleave(List<?> a , List<?> b,List<Object> c ){
      ArrayList<?> a1 = new ArrayList<>(a);
      ArrayList<?> b1 = new ArrayList<>(b);
      int i = 0;
      while(i < a1.size() && i < b1.size()){
          c.add(a1.get(i));
          c.add(b1.get(i));
          i++;
      }
      ArrayList<?> tmp = null;
      if(i < a1.size()){tmp = a1;}
      if(i < b1.size()){tmp = b1;}   
      while(tmp != null && i < tmp.size()){
          c.add(tmp.get(i));
          i++;
      }
}
public static void main(String arg[]){
    LinkedList<Integer> a = new LinkedList<>();
    ArrayList<Double> b = new ArrayList<>();
    ArrayList<Number> c = new ArrayList<>();
    a.add(1);
    b.add(2.0);
    a.add(3);
    a.add(5);
    b.add(4.0);
    a.add(6);
    interleave(a, b, c);
    System.out.println(c);
    }
}