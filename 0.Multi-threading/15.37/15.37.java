class Alarm{
    private final int duration;
    private final Thread alarm;
    private volatile boolean setted;

    public Alarm(int duration){
        this.duration = duration;
        this.setted = false;
        this.alarm = new Thread(()->{
            try{
                Thread.sleep(duration * 1000);
                System.out.println("Allarme!");
            }catch(InterruptedException e){
                return;
            }
        });
    }

    public void anomalyStart(){
        if(setted == false){
            alarm.start();
            setted = true;
            }
    }

    public void anomalyEnd(){
        alarm.interrupt();
        setted = false;
    }

    public static void main(String[] args) throws InterruptedException {
        Alarm a = new Alarm(5);
        a.anomalyStart();
        Thread.sleep(8000);
        a.anomalyEnd();
    }

}