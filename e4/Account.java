import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Account {
    public Person owner(){
        return null;
    }

    public Integer balance(){
        return null;
    }

    public void changeOowner(Person newOwner){
    }

    public static Account create(Person owner){
        return null;
    }

    public static <V> List<V> allValues(Map<?,V> map , List<?> keys){
        List<V> ret = new LinkedList<V>();
        for(Object o : keys){
            if(map.get(o) != null) ret.add(map.get(o));
        }
        return ret;
    }

    public void test(Collection<? super String> map){}
    public static void main(String[] args) {
      /*Function<Person,Account> f = Account::create;  
      Function<Account,Person> f1 = Account::owner;
      Account a = null;
      Supplier<Integer> s = a::balance;  
      Function<Account,Integer> f2 = Account::balance;
*/
      Map<Object,String> map = new HashMap<>();
      map.put(1,"uno");
      map.put(2.3,"due");
      map.put(3,"tre");
      List<Integer> keys = new LinkedList<>();
      keys.add(1);
      keys.add(2);
      System.out.println(allValues(map,keys));

        
    } 
}

class Person{

}