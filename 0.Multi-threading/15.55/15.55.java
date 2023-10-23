import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

interface RunnableWithArg<T> {
    void run(T x);
    }

class RunOnSet<T> extends Thread{
    
    BlockingQueue<T> queue;
    RunnableWithArg<T> runnable;

    public RunOnSet(RunnableWithArg<T> r , Set<T> s){
        queue = new LinkedBlockingQueue<T>(s);
        this.runnable = r;
    }

    public void run(){
        int n = queue.size();
        for(int i = 0 ; i < n ; i++){
            new Thread(new Runnable(){
                public void run(){
                    T val;
                    try {
                        val = queue.take();
                        runnable.run(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<Integer>();
s.add(3); s.add(13); s.add(88);
RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
public void run(Integer i) {
System.out.println(i/2);
}
};
Thread t = new RunOnSet<Integer>(r, s);
t. start () ;

    }

}