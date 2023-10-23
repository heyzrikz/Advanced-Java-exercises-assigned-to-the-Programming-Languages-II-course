public abstract class GreenPass{

    private boolean base;
    private Person proprietario;
    private int data_ultima_somministrazione;

    GreenPass(Person p , boolean b, int d){
        base = b;
        proprietario = p;
        data_ultima_somministrazione = d;
    }

    public boolean isValidOn(int day){
        if(base == true && day > 180 + data_ultima_somministrazione) return false;
        if(base == false && day > 270 + data_ultima_somministrazione) return false;
        if(day < 0) throw new IllegalArgumentException();
        return true; 
    }

    public boolean belongsTo(Person p){
        return p.equals(proprietario);
    }
}