import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MultiBuffer<T>{
    private List<LinkedList<T>> listOfBuffer;
    private final Object mutex = new Object();
    private volatile int index = 0;
    private int num;

    public MultiBuffer(int n){
        this.num = n;
    listOfBuffer = new ArrayList<LinkedList<T>>();
        for(int i = 0 ; i < n ; i++){
            listOfBuffer.add(new LinkedList<T>());
        }
    }

    public void insert(T val){
        synchronized(mutex){
            listOfBuffer.get(index).add(val);
            index++;
            if(index >= num) index = 0;
            mutex.notifyAll();
        }
    }

    public T take(int i){
        synchronized(mutex){
            while(listOfBuffer.get(i).size() == 0){
                try{
                    System.out.println("attendo");
                mutex.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        return listOfBuffer.get(i).get(0);
        }
    }

    public static void main(String[] args) {
        MultiBuffer<Integer> mb = new MultiBuffer<Integer>(3);
        new Thread(new Runnable() {
            public void run(){
                System.out.println(mb.take(0));
            }
        }).start();
        mb.insert(13);
        mb.insert(24);
        mb.insert(35);
        
    }
}