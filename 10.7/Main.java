public class Main {
    public static void main(String[] args){
        Controller c = new Controller();
        Controller.Function ac = c.addFunction("Aria condizionata");
        Controller.Function risc = c.addFunction("Riscaldamento");
        Controller.Function sedile = c.addFunction("Sedile riscaldato");
        ac.setIncompatible(risc );
        ac.setIncompatible(sedile );
        ac.turnOn();
        c.printOn();
        System.out.println("-----");
        risc .turnOn();
        sedile .turnOn();
        c.printOn();
    }
    
}
