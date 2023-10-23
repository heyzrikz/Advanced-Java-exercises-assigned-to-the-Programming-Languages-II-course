public class Contenitore {
    private int parametro;

    public static class ClasseInterna{
        public int par_interno = parametro;
        public void e(){
            parametro = 2;
        }
    }

    public void f(){
        ClasseInterna c = new ClasseInterna();
        if(c.par_interno == 2) System.out.println("ok"); 
    }


}
