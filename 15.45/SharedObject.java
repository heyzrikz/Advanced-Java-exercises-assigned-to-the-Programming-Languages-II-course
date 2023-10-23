/*

*/
public class SharedObject{
    public static void main(String[] args) throws InterruptedException {
        class MyThread extends Thread {
        private int id;
        private int arr[];
        public MyThread(int id, int arr[]) {
        this.id = id;
        this.arr = arr;
        }
        public void run() {
        synchronized (arr) {
            System.out.println("mutex");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        arr[0]++;
        System.out.println(id + ":" + arr[0]) ;
        }
        return;
        }
        }
        int[] a = { 0 };
        int[] b = { 0 };
        int[] c = { 0 };

        Thread t1 = new MyThread(1,a);
        Thread t2 = new MyThread(2,b);
        Thread t3 = new MyThread(3,c);
        t1. start () ; t2. start () ; t3. start () ;
        }
         
}