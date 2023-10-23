/*
 Output:
 1:1 2:2 3:3
 3:1 1:2 2:3
 2:1 3:2 1:3
 1:1 3:2 2:3
 ...in poche parole stamperà in ordine casuale 1,2 o 3 e dopo i due punti in ordine fisso 1,2,3
 */

class Main{
    public static void main(String[] args) throws InterruptedException {
        class MyThread extends Thread {
        private int id;
        private int[] arr;
        public MyThread(int id, int[] arr) {
        this.id = id;
        this.arr = arr;
        }
        public void run() {
        synchronized (arr) {
        arr[0]++;
        System.out.println(id + ":" + arr[0]) ;
        }
        return;
        }
        }
        int [] a = { 0 };
        Thread t1 = new MyThread(1,a);
        Thread t2 = new MyThread(2,a);
        Thread t3 = new MyThread(3,a);
        t1. start () ; t2. start () ; t3. start () ;
        } 
}