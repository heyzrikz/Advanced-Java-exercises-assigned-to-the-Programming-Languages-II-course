import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String arg[]) throws InstantiationException, IllegalAccessException{
        C i = new C();
        System.out.println(Super.getSuperclasses(i));
        ArrayList<A> array = new ArrayList<>();
        array.add(new A());
        array.add(new A());
        array.add(new B());
        array.add(new C());
        System.out.println(Super.getByType(array, C.class));
        Super.countByType(array);
    }
}

class A{

}

class B extends A{

}

class C extends B{

}
