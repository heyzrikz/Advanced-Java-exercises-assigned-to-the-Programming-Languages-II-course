import java.util.Iterator;

public class SuperclassIterator implements Iterator<Class<?>>{
    private Object partenza;
    public SuperclassIterator(Object o){
        partenza = o;
    }

    public boolean hasNext(){
        if(partenza != null) return true;
        return false;
    }

    public Class<?> next(){
        Class<?> ret = partenza.getClass();
        try {
            if(ret != Object.class)
                partenza = ret.getSuperclass().newInstance();
            else partenza = null;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }

    public static void main(String[] args) {
        Iterator<Class<?>> i = new SuperclassIterator(new
Manager("Franco"));
while (i.hasNext())
System.out.println(i .next());
    }

}

class Employee{

}

class Manager extends Employee{
    Manager(){

    }

    Manager(String s){
        
    }
}


/*
 
c)
e)
f)
i) preferibile
 */