import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicWeightedSet<T> implements WeightedSet<T>{
    private int least;
    private Map<Integer,ArrayList<T>> elementi;
    private  BasicWeightedSet<T> padre;
    private static Map<BasicWeightedSet,ArrayList<BasicWeightedSet>> collegamenti = new HashMap<>();
    
    public WeightedSet<T> atLeast(int threshold){
        Map<Integer,ArrayList<T>> m = elementi;
        for(Integer i:m.keySet()){
            if(i < Integer.valueOf(threshold)){
                m.get(i).removeAll();
            }
        }
    BasicWeightedSet ret = new BasicWeightedSet(threshold,this,m);
    collegamenti.get(this).add(ret);
    return ret;
    }

    //nota per comprensione: errore di ricopiatura da brutta a bella sostituire map-->elementi
    public void add_T(T obj , int weight){
        if(weight < least) throw new RuntimeException();
        if(map.get(Integer.valueOf(weight)) != null){
            map.get(Integer.valueOf(weight)).add(obj);
        }else{
            ArrayList<T> e = new ArrayList<>();
            e.add(obj);
            map.put(Integer.valueOf(weight),e);
        }
    }
    

    public void add(T obj, int weight){
        if(padre == null){
            add_T(obj,weight);}
        for(BasicWeightedSet i:collegamenti.get(padre)){
            i.add_T(obj,weight);
        }
        padre.add_T(obj,weight);
    
    }

    BasicWeightedSet(){
        least = 0;
        elementi = new HashMap<Integer,ArrayList<T>>();
        padre = null;
        collegamenti.put(this,new ArrayList<BasicWeightedSet>());
    }

    BasicWeightedSet(int t , BasicWeightedSet b , Map<Integer,ArrayList<T>> m){
        least = t;
        padre = b;
        elementi = m;
    }

    public String toString(){
        String ret = "";
        for(Integer i : elementi.keySet()){
            for(T e : elementi.get(i)){
                ret = ret + " "+e.toString();
            }
        }
    return ret;
    }

}