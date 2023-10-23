public class Engine{
    private double cilindrata;
    private double cavalli;
    private boolean byvolume = true;
    private boolean bypower = true;

    Engine(double ci , double ca){
        cilindrata = ci;
        cavalli = ca;
    }

    Engine(double ci , double ca,boolean v , boolean p){
        cilindrata = ci;
        cavalli = ca;
        byvolume = v;
        bypower = p;
    }

    public String toString(){
        return "("+cilindrata+" cm3, "+cavalli+" CV)";
    }

    public boolean equals(Object o){
        if(!(o instanceof Engine)) return false;
        Engine e = (Engine) o;
        if(byvolume == false && bypower == false) return false;
        if(byvolume == true && bypower == false) return (e.cilindrata == cilindrata);
        if(byvolume == false && bypower == true) return (e.cavalli == cavalli);
        return ((e.cilindrata == cilindrata)&&(e.cavalli == cavalli));
    }

    public Engine byVolume(){
      return new Engine(cilindrata,cavalli,true,false);
    }

    public Engine byPower(){
        return new Engine(cilindrata,cavalli,false,true);

    }



}