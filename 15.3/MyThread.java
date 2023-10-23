/*
a) NO
b) NO
c) SI
d) NO
e) SI
f) SI
g) NO
h) NO
i) SI
j) NO
*/

class MyThread extends Thread {
    public static int a[] = {6,7,8,9,10};
    public static int b[] = {1,2,3,4,5};
    public void run() {
        synchronized(MyThread.class){ //_____1_____
            
        for (int i=0; i<a.length; i++) {
            //_____2_____
                System.out.println(Thread.currentThread().getName()+": prendo monitor");
        if (a[ i ] > b[i]) {
            System.out.println(Thread.currentThread().getName()+": scambio a["+i+"]:"+a[i]+" con b["+i+"]:"+b[i]);
        int temp = b[i];
        b[i ] = a[i ];
        a[ i ] = temp;
        }
        System.out.println(Thread.currentThread().getName()+": rilascio monitor");
    //_____3_____
        }
        
    }//_____4_____
        }
        public static void print(){
            System.out.println("a: ");
            for(int i = 0; i< 5 ; i++){
                System.out.print(a[i]+" ");
            }
            System.out.println("");
            System.out.println("b: ");
            for(int i = 0; i< 5 ; i++){
                System.out.print(b[i]+" ");
            }
        }
        }

class Main{
public static void main(String[] args) throws InterruptedException {
 Thread th1 = new MyThread();
 Thread th2 = new MyThread();
 th1.start();
 th2.start();
 th1.join();
 th2.join();
 MyThread.print();   
}
}

