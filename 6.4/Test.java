import java.util.LinkedList;

class Test implements Runnable {
 private Thread thread;

 public Test() {
 thread = new Thread();
 }

 public void run() {
 int i = 0;
 for (i=0; i<10 ;i++)
 System.out.println("␣i␣=␣" + i);
 }

 public <T> LinkedList<T> merge(LinkedList<T> a , LinkedList<T> b){
    if(a.size() != b.size()) throw new IllegalArgumentException();
    LinkedList<T> ret = new LinkedList<>();
    for(int i = 0; i<a.size(); i++){
        ret.add(a.get(i));
        ret.add(b.get(i));
    } 
    return ret;
 }

 public static void main(String args[]) {
 Test t = new Test();
 //t. run () ;
 LinkedList<Integer> a = new LinkedList<>();
 LinkedList<Integer> b = new LinkedList<>();
 a.add(1);
 a.add(2);
 a.add(3);
 b.add(4);
 b.add(5);
 b.add(6);
for(Integer i : t.merge(a, b)){
    System.out.println(i);
}
 }


}