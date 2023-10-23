public class Person {
    private String nome;
    private int n_vaccinazioni;

    Person(String n){
        nome = n;
        n_vaccinazioni = 0;
    }

    public GreenPass vaccinate(int day){
        if(n_vaccinazioni == 0){
            n_vaccinazioni++;
            return new GreenPass(this,true,day){};
        }else{
            n_vaccinazioni++;
            return new GreenPass(this,false,day){};
        }
       
    }

    public boolean equals(Object o ){
        if(!(o.getClass() == getClass())) return false;
        Person p = (Person) o;
        return p.nome.equals(nome);
    }
}