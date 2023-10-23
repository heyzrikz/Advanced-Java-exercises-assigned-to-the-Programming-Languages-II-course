import java.util.Iterator;

public class CommonDividers implements Iterable<Integer>{
    private int first;
    private int second;
    private Integer current = 1;

    CommonDividers(int i , int j){
        first = i;
        second = j;
        while((first % current != 0 || second % current != 0) && current <= first){
            current++;
        }
        if(current > first){
            current = null;
        }
    }






    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            public boolean hasNext(){
                if(current == null) return false;
                return true;
            } 

            public Integer next(){
                Integer temp = current;
                current++;
                while((first % current != 0 || second % current != 0) && current <= first){
                    current++;
                }
                if(current > first){
                    current = null;
                }
                return temp;
            }





        };


    }
}