import java.util.HashSet;

public class Container{
    private double water;
    private HashSet<Container> tubo;
    Container(){
        water = 0;
        tubo = new HashSet<Container>();
    }
    Container(double w){
        water = w;
        tubo = new HashSet<Container>();
    }

    public double getAmount(){
        return water;
    }

    private void setAmount(int w){
        water = w;
    }

    public void connect(Container c){
        tubo.add(c);
        double w = water;
        for(Container co : tubo){
            w = co.water + w;
        }
        water = w/(tubo.size()+1);
        for(Container co : tubo){
            co.tubo.add(this);
            co.water = water;
        }
    }

    
        public void addWater(double w){
            water = w + water;
        }

}