import java.util.Comparator;

/*
a) funzionale, completa, corretta, non offre ulteriori garanzie, semplicità: 1
b) non completa poichè accetta solo Comparator<Object>
c) non è funzionale poichè S e T non sono confrontabili
d) non funzionale poichè Comparator dovrebbe accettare T e tutti i suoi super tipi
e) funzionale, completa, corretta, offre ulteriori garanzie sui due Comparatori, semplicità: 1
f) non completa poichè accetta solo a e b di tipo T che estende direttamente S

*/
class Agree{
    public static <T> boolean agree(Comparator<? super T> c1 , Comparator<? super T> c2, T a , T b){
        if(c1.compare(a,b)> 0 && c2.compare(a,b)> 0)return true;
        if(c1.compare(a,b)< 0 && c2.compare(a,b)< 0)return true;
        if(c1.compare(a,b)== 0 && c2.compare(a,b)== 0)return true;
        return false;
    }

    public static void main(String arg[]){
        System.out.println(agree(new Comparator<Object>() {
            public int compare(Object a , Object b){
                return 0;
            }
        }, new Comparator<Object>() {
            public int compare(Object a , Object b){
                return 0;
            }
        }, new Integer(0), new Integer(2)));
    }
}