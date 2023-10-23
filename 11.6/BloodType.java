public enum BloodType{
    A,B,AB,ZERO;
    public boolean canReceiveFrom(BloodType x){
        if(this == BloodType.AB) return true;
        if(x == BloodType.ZERO) return true;
        if(this == x) return true;
        return false;
    }
}