/*
a)b)c) non vanno bene poichè può accadere che vanno a effettuare lo switch dei campi nello stesso istante e questo può causare risultati inattesi
e)f)j)k) vanno poichè ogni volta che devono modificare l'array il thread prende in possesso il monitor solo se disponibile
*/
class MyThread extends Thread {
    public static int[] a = {1,2,3,4,5,6,7,8,9,10};
    public void run() {
        
    final int n = a.length - 1;
    //_____1_____
        
        for (int i=0; i <= n/2; i++) {
    synchronized(a){//_____2_____
        System.out.println(Thread.currentThread().getName()+": prende monitor");
    // scambia a[i ] e a[n−i]
    System.out.println(Thread.currentThread().getName()+": scambia "+a[i]+" con "+a[n-i]);
    int temp = a[i];
    a[ i ] = a[n - i];
    a[n - i] = temp;
    System.out.println(Thread.currentThread().getName()+": rilascia monitor");
    }//_____3_____
    }
    
        //_____4_____
    }
    }

    class Main{
        public static void main(String arg[]) throws InterruptedException{
            MyThread th1 = new MyThread();
            MyThread th2 = new MyThread();
            MyThread th3 = new MyThread();
            MyThread th4 = new MyThread();
            th1.start();
            th2.start();
            th3.start();
            th4.start();
            th1.join();
            th2.join();
            th3.join();
            th4.join();
            for(int i = 0 ; i < MyThread.a.length ; i++)
            System.out.println(MyThread.a[i]);

        }
    }