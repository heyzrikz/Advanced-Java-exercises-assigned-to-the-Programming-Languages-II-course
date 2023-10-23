import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class TwoThreads{

    public void program(List<Integer> list ){
        list.clear();
        final Object mutex = new Object();
        Thread reader = new Thread(()->{
            while( ! Thread.currentThread().isInterrupted()){
                synchronized(mutex){
                    int sum = 0;
                    try{
                    for(int i = 0 ; i < list.size() ; i++){
                        sum = sum + list.get(i);
                    }
                    System.out.println(sum);
                    Thread.sleep(1000);
                    mutex.wait();
                    }catch(InterruptedException i){
                        return;
                    }
                }
            }
        });

        new Thread(()->{
            Random r = new Random();
            int num = r.nextInt();
            while(num % 100 != 0){
                synchronized(mutex){
                    try{
                    list.add(num);
                    mutex.notifyAll();
                    Thread.sleep(100);
                    num = r.nextInt();
                    }catch(InterruptedException i){
                        return;
                    }
                }
                
            }
            reader.interrupt();
        }).start();
        reader.start();
        
    }

}

class Main{
    public static void main(String arg[]){
        TwoThreads t = new TwoThreads();
        t.program(new LinkedList<Integer>());
    }
}