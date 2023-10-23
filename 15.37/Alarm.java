public class Alarm{
    private long timeout;
    private boolean anomaly;
    private Thread alarm;


    public Alarm(int timeout){
        this.timeout = timeout * 1000;
        this.anomaly = false;
    }

    public void anomalyStart() throws InterruptedException{
        if(anomaly == false){
            System.out.println("----anomalia lanciata----");
            anomaly = true;
            Thread th = new Thread(new Runnable(){
                public void run(){
                    try{
                        Thread.sleep(timeout);
                        System.out.println("Allarme!");
                        anomaly = false;
                    }catch(InterruptedException i){
                        anomaly = false;
                        System.out.println("----anomalia interrotta----");
                        return;
                    }
                }
            });
            th.start();
            alarm = th;
       }
    }


    public void anomalyEnd(){
        if(anomaly == true){
            alarm.interrupt();
        }
    }

}

class Main{
    public static void main(String[] args) throws InterruptedException {
        Alarm a = new Alarm(5);
        a.anomalyStart();
        Thread.sleep(3000);
        a.anomalyEnd();
    }
}