public class Studente{
    private String nome;
    private String matricola;
    Studente(String n , String m){
        nome = n;
        matricola = m;
    }

    

    public boolean equals(Object o){
        if(!(o instanceof Studente)) return false;
        Studente s = (Studente) o;
        return (nome.equals(s.nome)) && (matricola.equals(s.matricola));
    }

    public String toString(){
        if(nome == null || matricola == null) throw new NullPointerException();
        return nome+" "+matricola;
   
    }

    public static class Triennale extends Studente{
        private static String prefix;
        public static void setPrefisso(String p){
            prefix = p;
        }

        Triennale(String n , String m){
            super(n,prefix+m);
           
        }

    }

    public static class Magistrale extends Studente{
        private static String prefix;
        public static void setPrefisso(String p){
            prefix = p;
        }
        
        Magistrale(String n , String m){
            super(n,prefix+m);
        }
    }
}