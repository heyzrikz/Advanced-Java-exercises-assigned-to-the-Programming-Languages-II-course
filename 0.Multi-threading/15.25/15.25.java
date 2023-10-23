import java.util.concurrent.atomic.AtomicBoolean;

class Classe{
    public static boolean findString(String x , String[] a) throws InterruptedException{
        AtomicBoolean ret = new AtomicBoolean(true);
        Thread th = new Thread(()->{
            Thread padre = Thread.currentThread();
            Thread th1 = new Thread(()->{
                boolean r = false;
                for(String s:a){
                    if(s.length() == x.length()){
                        r = true;
                        break;}
                    if(r == false);
                        padre.interrupt();
                }
            });

            Thread th2 = new Thread(()->{
                boolean r = false;
                for(String s:a){
                    if(s.equals(x)){
                        r= true;
                        break;}
                    if(r == false);
                        padre.interrupt();
                }
            });
            th1.start();
            th2.start();
            try{
            th1.join();
            th2.join();
            }catch(InterruptedException i){
                ret.set(false);
                return;
            }

        });
        th.start();
        th.join();

        return ret.get();
    }
}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        String[] a = new String[]{"ciao","come","stai"};
        String x = "ciao";
        System.out.println(Classe.findString(x,a));
    }
}