public class Auction{
    private int base;
    private Thread battitore;
    private String vincitore;
    private boolean asta_terminata = false;

    public Auction(int base){
        this.base = base;
        this.vincitore = "";
        this.battitore = new Thread(new Runnable(){
            public void run(){
                try{
                    Thread.sleep(3000);
                    System.out.println("Oggetto venduto a "+vincitore+" per "+base+" euro.");
                    asta_terminata = true;
                }catch(InterruptedException e){
                    return;
                }
            }
        });
    }

    public void makeOffer(int offer, String name){
        synchronized(vincitore){
            if(offer > base && asta_terminata == false){
                battitore.interrupt();
                base = offer;
                vincitore = name;
                battitore = new Thread(new Runnable(){
                    public void run(){
                        try{
                            Thread.sleep(3000);
                            System.out.println("Oggetto venduto a "+vincitore+" per "+base+" euro.");
                            asta_terminata = true;
                        }catch(InterruptedException e){
                            return;
                        }
                    }
                });
                battitore.start();
            }       
        }
    }

}

class Main{
    public static void main(String[] args) throws InterruptedException {
        Auction a = new Auction(1000);
a.makeOffer(1100, "Marco");
a.makeOffer(1200, "Luca");
Thread.sleep(1000);
a.makeOffer(200, "Anna");
Thread.sleep(1000);
a.makeOffer(1000, "Giulia" );
Thread.sleep(4000);
    }
}