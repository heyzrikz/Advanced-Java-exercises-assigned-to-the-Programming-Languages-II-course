import java.util.HashSet;

public class Controller{

    public class Function{
        private boolean on = false;
        private String name;
        private HashSet<Function> incompatible = new HashSet<>();
        Function(String n , boolean o){
            name = n;
            on = o;
        }

        public boolean isOn(){
            return on;
        }

        public String getName(){
            return name;
        }

        public void turnOn(){
            on = true;
            for(Function f : incompatible){
                f.turnOff();
            }
        }

        public void turnOff(){
            on = false;
        }

        public void setIncompatible(Function f){
            incompatible.add(f);
            f.incompatible.add(this);
        }
    }

    private HashSet<Function> funzioni = new HashSet<>();

    public Function addFunction(String name){
        Function f = new Function(name, false);
        funzioni.add(f);
        return f;
    }

    public void printOn(){
        for(Function f : funzioni){
            if(f.isOn()) System.out.println(f.getName()); 
        }
    }
}