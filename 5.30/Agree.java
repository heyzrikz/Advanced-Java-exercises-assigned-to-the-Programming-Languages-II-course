import java.util.Comparator;

/*
 a)funzionale, completo, corretto, non offre garanzie, semplicità: 1 
 b)non completo, accetta solo Comparator di Object GIUSTO E L'HO VERIFICATO GIù
 c)non funzionale
 d)non funzionale
 e)perfetto
 f)non funzionale
 
 */
public class Agree{
public static <S,T extends S> boolean agree(Comparator<S> c1 , Comparator<S> c2,T a , T b){
if(c1.compare(a, b) == c2.compare(a,b)) return true;
return false;
}
public static void main(String[] args) {
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