import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BlockingArray<T>{
    private List<T> array;
    BlockingArray(int size){
        array = new ArrayList<T>();
        for(int i = 0 ; i < size ; i++){
            array.add(null);
        }
    }
    
    public void put(int i , T val)throws InterruptedException{
        new Thread(new Runnable(){
            public void run(){
                synchronized(array){
                while(array.get(i) != null){
                    try {
                        array.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                array.set(i, val);
                array.notifyAll();
            }
            }
        }).start();
        
}

    public T take(int i) throws InterruptedException{
        AtomicReference<T> ret = new AtomicReference<>(null);
        Thread th = new Thread(new Runnable(){
            public void run(){
                synchronized(array){
                    while(array.get(i) == null){
                        try {
                            array.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ret.set(array.get(i)); 
                    array.set(i, null);
                    array.notifyAll();
                }
            }
        });
        th.start();
        th.join();

            return ret.get();
        }
    }


class Main{
public static void main(String[] args) throws InterruptedException{
    BlockingArray<String> arr = new BlockingArray<>(10);
    arr.put(0, "uno");
    arr.put(1, "due");
    System.out.println(arr.take(0));
    arr.put(1, "tre");
    System.out.println(arr.take(1));
}
}