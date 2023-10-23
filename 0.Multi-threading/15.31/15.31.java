//possibili output:
//1 2
//2 1
//2 2


class SimpleThread extends Thread
{
public static volatile int n = 0;
public void run() {
n++;
try {
    Thread.sleep(1);
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
int m = n;

System.out.println(m);
}

}
class Main{
    public static void main(String[] args) {
        SimpleThread t1 = new SimpleThread();
        SimpleThread t2 = new SimpleThread();
        t1.start();
        t2.start();
    }
}

class Run{
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ; i < 100; i++){
            Thread th = new Thread(()->{
                Main.main(args);
           });
            th.start();
            th.join();
            SimpleThread.n = 0;
            System.out.println("");
            
        }
    }
}
