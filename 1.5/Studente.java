
public class Studente {
    private String nome , matricola;
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Studente)) return false;
        Studente s = (Studente) o;
        return ((s.nome.equals(nome)) && (s.matricola.equals(matricola)));


    } 

    public String getValues(){
        return nome+" "+matricola;
    }
 
    Studente(String n , String m){
           nome = n;
           matricola = m;    
       }
    public static class Triennale extends Studente{
         private static String prefix;
        Triennale(String n , String m){
               super(n,prefix+m);
           }
        public static  void setPrefisso(String p){
               prefix = p;
           }
    }
    public static class Magistrale extends Studente{
         private static String prefix;
         public static  void setPrefisso(String p){
               prefix = p;
           }
           Magistrale(String n , String m){
               super(n,prefix+m);
           }
        
    }
  
}

