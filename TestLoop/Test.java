import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> li=new ArrayList<String>();
    for(int i=0;i<10;i++){
        li.add("str"+i);
    }

    for(int j = 0 ; j < li.size() ; j++){
        if(li.get(j).equalsIgnoreCase("str3"))
            li.remove("str3");
    }
    System.out.println(li);
    }
}
