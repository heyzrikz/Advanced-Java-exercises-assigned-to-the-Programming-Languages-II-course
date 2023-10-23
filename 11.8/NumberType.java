public enum NumberType{
BYTE(8),SHORT(16),INT(32),FLOAT(32),LONG(64),DOUBLE(64);
public int width;
NumberType(int n){
    width = n;
}
public boolean isAssignableTo(NumberType n){
    if(this.width <= n.width) return true;
    else return false;
}

public static void main(String arg[]){
    System.out.println(NumberType.SHORT.width);
    System.out.println(NumberType.DOUBLE.isAssignableTo(NumberType.FLOAT)
    ); 
}

}