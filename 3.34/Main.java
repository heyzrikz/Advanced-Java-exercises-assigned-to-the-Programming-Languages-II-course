public class Main {
    public static void main(String arg[]){
        TreeType melo = new TreeType("melo"
);
TreeType pero = new TreeType("pero")
;
Tree unMelo = new Tree(melo);
Tree unAltroMelo = new Tree(melo);
unAltroMelo.addGraft(pero);
unAltroMelo.addGraft(pero);
System.out.println("Sono stati creati "
+ melo.getCounter() + " meli fino a questo momento.");
System.out.println("Sono stati creati "
+ Tree.getCounter() + " alberi fino a questo momento.");
System.out.println(unAltroMelo);
unAltroMelo.addGraft(melo);


    }
    
}
