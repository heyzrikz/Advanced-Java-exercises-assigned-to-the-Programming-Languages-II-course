public class Main {
    public static void main(String arg[]){
        Calciatore osimhen = new Calciatore(Ruolo.ATTACCANTE,"Osimhen");
        if(osimhen.ruolo == Ruolo.ATTACCANTE)
        System.out.println(osimhen);
        osimhen.setSottoruolo(Sottoruolo.ATT);
        System.out.println(osimhen);

    }
}
