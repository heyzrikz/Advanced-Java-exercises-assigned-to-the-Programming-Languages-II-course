public class Average{
    private int somma;
    private int num;
    Average(){
        somma = 0;
        num = 0;
    }

    public void add(int v){
        somma = somma + v;
        num = num + 1;
    }

    public double getAverage(){
        if(num == 0) throw new RuntimeException();
        return (somma / num);
    }
}