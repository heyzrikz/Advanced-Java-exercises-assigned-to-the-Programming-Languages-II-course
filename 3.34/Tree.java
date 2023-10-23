import java.util.HashSet;
import java.util.Set;

public class Tree{
    private Set<TreeType> innesti;
    private TreeType type;
    private static int count = 0;
    Tree(TreeType t){
        type = t;
        t.num_tree++;
        count++;
        innesti = new HashSet<TreeType>();
    }

    public static int getCounter(){
        return count;
    }

    public void addGraft(TreeType t){
        if(!t.equals(type)) innesti.add(t);
        else throw new RuntimeException();
    } 

    public String toString(){
        return "tipo: "+type.toString()+"\n"+"innesti:"+innesti.toString()+"\n";
    }



}