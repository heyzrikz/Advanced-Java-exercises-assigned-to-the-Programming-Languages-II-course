public class Apparecchio{
    private int power;
    private boolean acceso;
    private Impianto myImpianto;
    Apparecchio(){
        power = 0;
    }

    Apparecchio(int p){
        power = p;
    }

    public boolean isOn(){
        return acceso;
    }

    public int getPower(){
        return power;
    }

    public void setImpianto(Impianto i){
        myImpianto = i;

    }

    public void on(){
        acceso = true;
        if(myImpianto.potenza() > myImpianto.getMaxPower()) throw new RuntimeException("Attenzione superata la potenza massima dell'impianto");
    }

    public void off(){
        acceso = false;
    }

    


}