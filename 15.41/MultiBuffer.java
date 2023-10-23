import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiBuffer<T>{
    private List<LinkedBlockingQueue<T>> elenco;
    private Object mutex = new Object();

    public MultiBuffer(int n){
        elenco = new ArrayList<LinkedBlockingQueue<T>>();
        for(int i = 0 ;i<n; i++){
            elenco.add(new LinkedBlockingQueue<T>());
        }
    }

    public void insert(T val) throws InterruptedException{
        synchronized(mutex){
            int min = Integer.MAX_VALUE;
            LinkedBlockingQueue<T> piccola = null;
            for(LinkedBlockingQueue<T> l : elenco){
                if(elenco.size() < min){
                    min = elenco.size();
                    piccola = l;
                }
            }
            piccola.put(val);
        }
    }

    public T take(int i) throws InterruptedException{
        synchronized(mutex){
            return elenco.get(i).take();
        }
    }

}

class Main{
    public static void main(String[] args) throws InterruptedException {
        MultiBuffer<Integer> mb = new MultiBuffer<Integer>(3);
mb.insert(13);
mb.insert(24);
mb.insert(35);
System.out.println(mb.take(0));
    }
}