/*
                t1                          t2                              t3                          main
               start                       start                           start                        sync(count)
               sync(x)                     attesa(x)                       attesa(x)                     count.wait
               count = 1                      .                               .                             .
               sync(count)                    .                               .                             .
               count.notify                  .                               .                          out:Incremento/count.wait
                x.wait                       sync(x)                         .                                  .
                    .                       count = 2                        .                                  .
                    .                       sync(count)                      .                                  .
                    .                       count.notify                     .                           out:Incremento/count.wait
                    .                           x.wait                      sync(x)                               .
                    .                              .                        count = 3                            .
                    .                              .                        sync(count)                          .
                    .                              .                         count.notify                        .
                    .                              .                           x.wait                        out:Fatto
                out:1                             out:2                         out:3                              end

                Incremento
                Incremento
                Incremento
                Fatto
                1        2
                2 oppure 3 oppure . . .
                3        1
*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Object x = new Object();
        final int [] count = new int[1];
        class MyThread extends Thread {
        int id;
        MyThread(int n) { id = n; }
        public void run() {
        synchronized (x) {
        count[0]++;
        synchronized (count) {
        count.notify () ;
        }
        try {
        x.wait();
        } catch (Exception e) { }
        }
        System.out.println(id);
        }
        }
        Thread t1 = new MyThread(1), t2 = new MyThread(2), t3 = new MyThread(3);
        t1. start () ; t2. start () ; t3. start () ;
        synchronized (count) {
        while (count[0]<3) {
        count.wait();
        System.out.println("Incremento");
        }
        }
        System.out.println("Fatto");
        synchronized (x) {
        x. notifyAll () ;
        }
        }
         
}
