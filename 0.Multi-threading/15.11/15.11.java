class GuessTheNumber{
    private Integer secret;
    private Integer soluzione_migliore = null;
    private Thread vincitore = null;
    private final Object mutex = new Object();

    

    public GuessTheNumber(int secret , long millis){
        this.secret = secret;
        new Thread(()->{
            
                try{
                    Thread.sleep(millis);
                    synchronized(mutex){
                    mutex.notifyAll();
                    this.secret = null;
                    }
                }catch(InterruptedException e){
                    return;
                }
            
        }).start();

    }

    public boolean guessAndWait(int sol) throws InterruptedException{
        synchronized(mutex){
            if(secret != null){
                System.out.println(Thread.currentThread().getName());
                if(soluzione_migliore == null){
                    soluzione_migliore = sol;
                    vincitore = Thread.currentThread();
                }else{
                    int s = soluzione_migliore - secret;
                    if(s < 0) s= s * (-1);
                    int t = sol - secret;
                    if(t < 0) t = t*(-1);
                    if(t < s){
                        soluzione_migliore = sol;
                        vincitore = Thread.currentThread();
                    }
                }
            }else return false;
            while(secret != null){
                mutex.wait();
            }
        }
        return vincitore==Thread.currentThread();
    }

    public static void main(String arg[]) throws InterruptedException{
        

       
                    GuessTheNumber g = new GuessTheNumber(5,10000);              
       

        Thread th1 = new Thread(new Runnable() {
            public void run(){
                try {
                    System.out.println("p1 vince: "+g.guessAndWait(7));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
       
        Thread th2 = new Thread(new Runnable() {
            public void run(){
                try {
                    System.out.println("p2 vince: "+g.guessAndWait(3));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread th3 = new Thread(new Runnable() {
            public void run(){
                try {
                    Thread.sleep(15000);
                    System.out.println("p3 vince: "+g.guessAndWait(3));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        th1.start();
        th2.start();
        th3.start();

    }

}