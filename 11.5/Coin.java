import java.util.LinkedList;
import java.util.List;

public enum Coin{
    TWOEUROS,ONEEURO,FIFTYCENT,TWENTYCENT,TENCENT,FIVECENT,TWOCENT,ONECENT;
    static int monete[] = {200,100,50,20,10,5,2,1};
    private static Coin change(int e){
        if(e == 200) return Coin.TWOEUROS;
        if(e == 100) return Coin.ONEEURO;
        if(e == 50) return Coin.FIFTYCENT;
        if(e == 20) return Coin.TWENTYCENT;
        if(e == 10) return Coin.TENCENT;
        if(e == 5) return Coin.FIVECENT;
        if(e == 2) return Coin.TWOCENT;
        return Coin.ONECENT;
    }

    public static List<Coin> convert(int euro){
        List<Coin> ret = new LinkedList<>();
        while(euro != 0){
         for(int i = 0; i<8; i++){
            if(euro - monete[i] >= 0){
                ret.add(change(monete[i]));
                euro = euro - monete[i];
                break;
            }
         }
        }
        return ret;
    }
}