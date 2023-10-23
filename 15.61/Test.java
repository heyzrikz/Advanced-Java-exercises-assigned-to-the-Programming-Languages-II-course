class Test extends Thread {
     private Thread thread;
    
     public Test() {
     thread = new Thread();
     }
    
     public void run() {
     int i = 0;
     for (i=0; i<10 ;i++)
     System.out.println("i = " + i);
     }
    
     public static void main(String args[]) {
     Test t = new Test();
     t.start();
     }
     }
    