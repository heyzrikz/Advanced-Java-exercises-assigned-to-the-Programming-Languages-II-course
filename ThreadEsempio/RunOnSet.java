import java.util.Collection;

public class RunOnSet<T> extends Thread{
    private Collection<T> coll;
    private Runnable ru;
    RunOnSet(RunnableWithArg<T> r ,Collection<T> c){
        coll = c;
        ru = new Runnable() {
            public void run(){
                for(T t : coll){
                    r.run(t);
                }
            }
        };
    }
    
    public void run(){
        new Thread(ru).start();
    }
}

//fai 1 esercizio firma e thread