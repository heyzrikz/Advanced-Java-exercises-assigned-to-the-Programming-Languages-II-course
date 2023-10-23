import java.util.HashSet;

public class Impianto{

    private int max_power;

    HashSet<Apparecchio> set = new HashSet<>();
    public void collega(Apparecchio a){
        set.add(a);
        a.setImpianto(this);
    }

    Impianto(){
        max_power = 0;
    }

    Impianto(int p){
        max_power = p;
    }

    public int potenza(){
        int potenza = 0;
        for(Apparecchio a:set){
            if(a.isOn()) potenza = potenza + a.getPower();
        }
        return potenza;
    }

    public int getMaxPower(){
        return max_power;
    }
}