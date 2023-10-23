import java.util.ArrayList;
import java.util.Collection;

public class Get{
    public static <T> T getByType(Collection<?> c , Class<T> x) throws InstantiationException, IllegalAccessException{
        for(Object t : c){
            if(t.getClass() == x) return x.newInstance();
        }
        return null;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Collection<A> c = new ArrayList<>();
        c.add(new A());
        c.add(new C());
        c.add(new C());
        c.add(new C());
        Class<C> x = C.class;
        System.out.println(Get.getByType(c,x).getClass());
    }
}

class A{

}

class B extends A{

}

class C extends A{

}