//esercizio 1
public static void reset(Object o) throws IllegalArgumentException, IllegalAccessException{
    for(Field fi : o.getClass().getFields()){
        if(fi.getType() == int.class) fi.set(o,0);
    }
}

//esercizio 2
public static Class<?> getSuperclasses(Object o) throws InstantiationException, IllegalAccessException{
    if(o.getClass().getSuperclass() == Object.class){ return o.getClass();}
    else return getSuperclasses(o.getClass().getSuperclass().newInstance());

}
