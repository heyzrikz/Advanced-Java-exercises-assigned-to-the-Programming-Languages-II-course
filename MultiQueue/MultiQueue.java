import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiQueue <T>{
    private List<LinkedBlockingQueue<T>> list;
    private final Object mutex = new Object();
    private int size;
    public MultiQueue(int size){
        this.size = size;
        list = new ArrayList<LinkedBlockingQueue<T>>();
        for(int i = 0 ; i < size ; i++){
            list.add(new LinkedBlockingQueue<T>());
        }
    }

    public void add(T val) throws InterruptedException{
        synchronized(mutex){
            Integer dim = null;
            LinkedBlockingQueue<T> min = null;
            for(int i = 0 ; i < size ; i++){
                if(dim == null || (dim != null && list.get(i).size() < dim)){
                    dim = list.get(i).size();
                    min = list.get(i);
                }
            }
            min.put(val);
        }
    }

    public T get(int index) throws InterruptedException{
        return list.get(index).take();
    }
}

class UseCase{
    public static void main(String[] args) throws InterruptedException {
        MultiQueue<String> q = new MultiQueue<>(3);
        q.add("uno");
        q.add("due");
        q.add("tre");
        q.add("quattro");
        String s = q.get(0);
        String t = q.get(0);
        System.out.println(t);

    }
}

class Run{
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ; i < 10 ; i ++){
            UseCase.main(args);
        }
    }
}
