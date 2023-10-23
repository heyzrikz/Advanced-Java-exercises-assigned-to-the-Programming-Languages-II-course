import java.util.HashMap;
import java.util.Map;

public class Progression{
    private int base;
    private int incremento;
    private Map<String,DatiCarriera> impiegati;
    
    Progression(int b , int i){
        base = b;
        incremento = i;
        impiegati = new HashMap<String,DatiCarriera>();
    }

    private class DatiCarriera{
        private int bonus;
        private int anno_assunzione;
        private int anno_bonus;
        DatiCarriera(int b , int a , int a_b){
            bonus = b;
            anno_assunzione = a;
            anno_bonus = a_b;
        }

        private void setBonus(int b,int a){
            bonus = b;
            anno_bonus = a;
        }
    }

    public void addEmployee(String nome, int anno){
        impiegati.put(nome,new DatiCarriera(0,anno,0));
    }

    public void addBonus(String nome,int anno_bonus,int bonus){
        impiegati.get(nome).setBonus(bonus,anno_bonus);
    }

    public int getSalary(String nome , int anno){
        DatiCarriera dati = impiegati.get(nome);
        int salario = base;
        for(int i = anno ; i > dati.anno_assunzione ; i--) salario = salario + incremento;
        if(anno - dati.anno_bonus == 0) salario = salario + dati.bonus;
        return salario; 
    }




}