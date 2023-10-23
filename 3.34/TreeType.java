public class TreeType{
    private String tipo;
    public int num_tree;
    TreeType(String t){
        tipo = t;
        num_tree = 0;
    }

    public boolean equals(Object o){
        if(!(o.getClass() == getClass())) return false;
        TreeType t = (TreeType) o;
        return t.tipo.equals(tipo);    
    }

    public int hashCode(){
        return tipo.hashCode();
    }

    public int getCounter(){
        return num_tree;
    }

    public String toString(){
        return tipo;
    }


}