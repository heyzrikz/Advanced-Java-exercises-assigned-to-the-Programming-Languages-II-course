import java.lang.reflect.Field;

public class Reset{
    public static void reset(Object o) throws IllegalArgumentException, IllegalAccessException{
        for(Field fi : o.getClass().getFields()){
            if(fi.getType() == int.class) fi.set(o,0);
        }
    }
}