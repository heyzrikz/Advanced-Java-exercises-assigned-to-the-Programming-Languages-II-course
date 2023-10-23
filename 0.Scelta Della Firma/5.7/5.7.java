/*
 a)funzionale, completa, corretta, offre garanzie massime, semplicita massima, tipo di ritorno poco specifico
 b)non completa poichè accetta solo Enum con lo stesso tipo parametrico T
 c)non completa poichè accetta sicuramente la stessa classe enumerata S
 d)non funzionale poichè non posso chaiamre ordinal() su b
 e)funzionale, completa, corretta, non offre ulteriori garanzie, semplicità: 1, tipo di ritorno poco specifico
 */

class Min {
   public static <T extends Enum<?>> T min(T a , T b){
    if(a.getClass() == b.getClass()){
        if(a.ordinal() > b.ordinal()) return a;
        if(a.ordinal() < b.ordinal()) return b; 
    }
    return null;
   } 
}
