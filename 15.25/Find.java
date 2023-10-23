import java.util.concurrent.atomic.AtomicBoolean;

public class Find{
    public static boolean findString(String x , String[] a) throws InterruptedException{
        AtomicBoolean stop = new AtomicBoolean(false);
        Thread th1 = new Thread(new Runnable(){
            public void run(){
                int i = 0;
                boolean check = false;
                while(i < a.length && stop.get() == false && check == false){
                    try {
                        System.out.println(Thread.currentThread().getName()+": check uguaglianza");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(x.equals(a[i])) check = true; 
                    i++;
                }
                System.out.println(Thread.currentThread().getName()+": esco");
                if(check == false) stop.set(true);
            }
        });

        Thread th2 = new Thread(new Runnable(){
            public void run(){
                int i = 0;
                boolean check = false;
                while(i < a.length && stop.get() == false && check == false){
                    if( x.length() == a[i].length() ) check = true;
                    i++;
                }
                if(check == false){stop.set(true);
                    System.out.println(Thread.currentThread().getName()+": termina tutti");
                }
            }
        });

        th1.start();
        th2.start();
        th1.join();
        th2.join();
        return ! stop.get();

    }
    public static void main(String arg[]) throws InterruptedException{
        String[] a = new String[]{"ciao","come","stai"};
        String x = "star";
        System.out.println(Find.findString(x,a));
    }
}