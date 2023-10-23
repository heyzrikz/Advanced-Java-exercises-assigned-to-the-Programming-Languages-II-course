/*
 output:
 1 2 3 4
 2 1 3 4
 1 2 4 3
 2 1 4 3 
 1 3 2 4 
 2 4 1 3 
 */
class Main {
    public static void main(String[] args) throws InterruptedException{
        class MyThread extends Thread {
        private int id;
        private Thread other;
        public MyThread(int n, Thread t) {
        id = n;
        other = t;
        }
        public void run() {
        try {
        if (other!=null)
        other. join () ;
        } catch (InterruptedException e) {
        return;
        }
        System.out.println(id);
        }
        }
        Thread t1 = new MyThread(1,null);
        Thread t2 = new MyThread(2,null);
        Thread t3 = new MyThread(3,t1);
        Thread t4 = new MyThread(4,t2);
        t1. start () ; t2. start () ; t3. start () ; t4. start () ;
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("");
        }
        }

        class Run{
            public static void main(String[] args) throws InterruptedException{
                for(int i = 0 ; i < 100 ; i++){
                Main.main(args);
            }
            }
        }
        

