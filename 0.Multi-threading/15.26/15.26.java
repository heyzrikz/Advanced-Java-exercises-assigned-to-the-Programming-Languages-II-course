import java.util.ArrayList;
import java.util.List;

class BlockingArray<T>{
    private List<T> array;
    private final Object mutex = new Object();
    private int size;

    public BlockingArray(int n){
        array = new ArrayList<T>(n);
        for(int i = 0 ; i < n; i++){
            array.add(null);
        }
        size = n;
    }

    public void put(int index, T val){
            if(index >= size) throw new RuntimeException("Array out of bounds");
            synchronized(mutex){
                while(array.get(index) != null){
                    try{
                    mutex.wait();
                    }catch(InterruptedException i){
                        return;
                    }
                }
                if(array.get(index) == null){
                    array.set(index,val);
                    mutex.notifyAll();
                }
            }        
    }

    public T take(int index) throws InterruptedException{
        if(index >= size) throw new RuntimeException("Array out of bounds");
        synchronized(mutex){
            while(array.get(index) == null){
                mutex.wait();
            }
            if(array.get(index) != null){
                T val = array.get(index);
                array.set(index,null);
                mutex.notifyAll();
                return val;
            }
        }
        return null;        
    }

    public static void main(String[] args) throws InterruptedException{
        BlockingArray<String> arr = new BlockingArray<>(10);
        arr.put(0, "uno");
        arr.put(1, "due");
        System.out.println(arr.take(0));
        arr.put(1, "tre");
        System.out.println(arr.take(1));
    }

}