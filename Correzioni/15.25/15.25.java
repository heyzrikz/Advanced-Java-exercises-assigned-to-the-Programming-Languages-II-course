import java.util.concurrent.atomic.AtomicBoolean;

class Find{
    public static boolean findString(String x , String[] a) throws InterruptedException{
        AtomicBoolean ret = new AtomicBoolean(true);
        final Object mutex = new Object();
        Thread th1 = new Thread(()->{
            for(String s : a){
                synchronized(mutex){
                if(ret.get() == false) return;
                }
                if(s.length() == x.length()) return;
                }
                synchronized(mutex){
                    ret.set(false);
                }
        });

         Thread th2 = new Thread(()->{
            for(String s : a){
                synchronized(mutex){
                if(ret.get() == false) return;
                }
                if(s.equals(x)) return;
                }
                synchronized(mutex){
                    ret.set(false);
                }
        });

    th1.start();
    th2.start();
    th1.join();
    th2.join();
    return ret.get();
       
}

public static void main(String arg[]) throws InterruptedException{
    String[] a = new String[]{"ciao","come","stai"};
    String x = "ci";
    System.out.println(Find.findString(x,a));
}
}