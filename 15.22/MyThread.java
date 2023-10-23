class MyThread extends Thread {
    public static int[] array;
    public void run() {
    int tot = 0;
    synchronized(array){//_____1_____
    for (int i=0; i<array.length; i++) {
        //_____2_____
            System.out.println(Thread.currentThread().getName()+" prende mutex");
    tot += array[i];
    array[ i ] = 0;
    System.out.println(Thread.currentThread().getName()+" rilascia mutex");
        //_____3_____
    }
}//_____4_____
    System.out.println(tot);
    }
    }

    class Main{
        public static void main(String arg[]) throws InterruptedException{
            MyThread.array = new int[]{1,2,3,4,5};
            MyThread th1 = new MyThread();
            MyThread th2 = new MyThread();
            th1.start();
            th2.start();
            th1.join();
            th2.join();
        }
    }

    class Run{
        public static void main(String[] args) throws InterruptedException {
            for(int i = 0 ; i < 1000; i++){
                Thread th = new Thread(()->{try {
                    Main.main(args);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }});
                th.start();
                th.join();
                System.out.println("");
                
            }
        }
    }