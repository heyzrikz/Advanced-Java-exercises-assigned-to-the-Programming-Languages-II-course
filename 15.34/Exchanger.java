public class Exchanger<T>{
    private T oggetto1 = null;
    private T oggetto2 = null;
    private int n_scambi = 2;
    private Object mutex = new Object();
    public T exchange(T val){
        T ret = null;
        synchronized(mutex){
            if(n_scambi == 0) throw new RuntimeException("già fatto uno scambio");
            if(oggetto1 == null && oggetto2 == null) oggetto1 = val;
            else{
                ret = oggetto1;
                oggetto2 = val;
                n_scambi--;
                mutex.notifyAll();
                return ret;
            }
            while(oggetto2 == null){
                try {
                    mutex.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            n_scambi--;
            ret = oggetto2;
            return ret;
        }
    }
}

class Main{
    public static void main(String[] args) {
        Exchanger<String> e = new Exchanger<String>();
        new Thread(new Runnable(){
            public void run(){
                String a = e.exchange("ciao");
                System.out.println(a);
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){
                String a = e.exchange("Pippo");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.out.println(a);
            }
        }).start();
    }
}