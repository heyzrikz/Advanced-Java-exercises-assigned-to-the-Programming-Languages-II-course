public enum Cardinal{
    NO("SE",14),NNO("SSE",15),N("S",0),NNE("SSO",1),NE("SO",2),
    ONO("ESE",13),ENE("OSO",3),
    O("E",12),E("O",4),
    OSO("ENE",11),ESE("ONO",5),
    SO("NO",10),SSO("NNE",9),S("N",8),SSE("NNO",7),SE("NO",6);

    private String opposto;
    private int coordinate;
    Cardinal(String o , int coo){
        opposto = o;
        coordinate = coo;
    }
    public boolean isOpposite(Cardinal c){
        return opposto.equals(c.name());
    }

    public static Cardinal mix(Cardinal c1,Cardinal c2){
        int res = (c1.coordinate + c2.coordinate)/2;
        for(Cardinal c : Cardinal.values()){
            if(c.coordinate == res) return c;
        }
        return null;
    } 
    
    public static void main(String arg[]){
        Cardinal nord = Cardinal.N;
System.out.println(nord.isOpposite(Cardinal.S));
Cardinal nordest = Cardinal.mix(Cardinal.N, Cardinal.E);
assert nordest==Cardinal.NE : "Errore␣inaspettato!";
Cardinal nordnordest = Cardinal.mix(nordest, Cardinal.ONO);
System.out.println(nordnordest);
    }
}