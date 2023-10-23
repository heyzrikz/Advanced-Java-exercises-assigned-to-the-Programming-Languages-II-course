public class Engine{
    private double cilindrata;
    private int cavalli;
    private boolean cmp_cilindrata = true;
    private boolean cmp_cavalli = true;

    Engine(){

    }

    Engine(double cil, int cav){
        cilindrata = cil;
        cavalli = cav;
        cmp_cavalli = true;
        cmp_cilindrata = true;
    }

    Engine(double cil, int cav,boolean cmp_cav,boolean cmp_cil){
        cilindrata = cil;
        cavalli = cav;
        cmp_cavalli = cmp_cav;
        cmp_cilindrata = cmp_cil;
    }


    public boolean equals(Object o){
        if(getClass() != o.getClass()) return false;
        Engine e = (Engine) o;
        if(cmp_cavalli && (cavalli != e.cavalli)) return false;
        if(cmp_cilindrata && (cilindrata != e.cilindrata)) return false;
        return true;
        
    }

    public Engine byVolume(){
        return new Engine(cilindrata,cavalli,false,true);
    }

    public Engine byPower(){
        return new Engine(cilindrata,cavalli,true,false);
    }

    public String toString(){
        return "("+cilindrata+" cm3, "+cavalli+" CV)";
    }


}