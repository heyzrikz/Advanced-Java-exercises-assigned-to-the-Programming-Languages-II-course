import java.util.Iterator;

public class B implements A.Convertible<T> , Iterable<?>{
    public T convert(){
        return null;
    }

    public Iterator<Z> iterator(){
        return new Iterator<Z>(){
            public boolean hasNext(){

            }

            public Z next(){

            }
        };
    }

    B(){

    }

    B(int n){

    }

    public static Iterator<?> g(B b){
        return null;
    }

}