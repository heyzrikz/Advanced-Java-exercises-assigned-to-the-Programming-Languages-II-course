import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bug{
    private static Set<Bug> unassigned = new HashSet<>();
    private static Map<String,Set<Bug>> assigned = new HashMap<>();
    private String descrizione;
    private String sviluppatore;
    Bug(String d){
        descrizione = d;
        sviluppatore = null;
        unassigned.add(this);
    }

    public void assignTo(String s){
        sviluppatore = s;
        unassigned.remove(this);
        if(assigned.get(sviluppatore) == null){
        Set<Bug> set = new HashSet<>();
        set.add(this);
        assigned.put(sviluppatore,set);
        }else{
            assigned.get(sviluppatore).add(this);
        }
    }

    public static Set<Bug> getAssignedTo(String s){
        return assigned.get(s);
    }

    public static Set<Bug> getUnassigned(){
        return unassigned;
    }

    public String toString(){
        return "(''"+descrizione+"'', "+"assigned to "+sviluppatore+")";
    }




}