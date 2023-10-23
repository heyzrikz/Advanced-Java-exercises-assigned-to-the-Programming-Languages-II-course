/*
 a) non completa poichè accetta solo un Comparator<Object>
 b) funzionale, completa, corretta, offre garanzie sulla lista, semplicità firma: 1 parametro di tipo
 c) funzionale, completa, corretta, non offre ulteriori garanzie, semplicità firma: 1 parametro i tipo
 d) non completa poichè accetta solo List e Comparator di Object
 e) non funzionale poichè T non è superiore a S nella gerarchia dei tipi
 f) non completa poichè accetta solo List di un tipo T che estende direttamente il tipo S di Comparator
 */

class Sorted{
    public static <S> boolean isSorted(List<? extends S> x , Comparator<? super S> c){
        if(x.size() == 0) return false;
        S prec = x.get(0);
        for(S s : x){
            if(c.compare(prec,s) > 0) return false;
        }
        return true;
    }
}
