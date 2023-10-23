import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ParkingLot{

    class Veicolo{
        private int id;
        private long orario_ingresso;

        public Veicolo(int id){
            this.id = id;
            orario_ingresso = System.currentTimeMillis();
        }

        public long getOrario(){
            return orario_ingresso;
        }
        public int getId(){
            return id;
        }
    }

    private BlockingQueue<Veicolo> queue;

    public ParkingLot(int num){
        queue = new ArrayBlockingQueue<Veicolo>(num);

        new Thread(()->{
            int id = 0;
            while(! Thread.currentThread().isInterrupted()){
                try{
                Thread.sleep(1000);
                queue.put(new Veicolo(id));
                id++;
                }catch(InterruptedException e){
                    return;
                }
            }
        }).start();

        new Thread(()->{
            while(! Thread.currentThread().isInterrupted()){
                try{
                Thread.sleep(2000);
                Veicolo veh = queue.take();
                long time = (System.currentTimeMillis() - veh.getOrario())/1000;
                System.out.println(veh.getId()+" è stato parcheggiato per "+time+" secondi");
                }catch(InterruptedException e){
                    return;
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        ParkingLot p = new ParkingLot(3);
    }

}