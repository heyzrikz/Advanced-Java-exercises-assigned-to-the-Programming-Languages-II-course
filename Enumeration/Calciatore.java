enum Sottoruolo{
    ATT,AS,AD,AT,COC,CC,CDC;
}

enum Ruolo{
    PORTIERE,DIFENSORE,CENTROCAMPISTA,ATTACCANTE;
    
}

public class Calciatore{
public Ruolo ruolo;
private String nome;
private Sottoruolo sottoruolo;
Calciatore(Ruolo r , String n){
    ruolo = r;
    nome = n;
}

public void setSottoruolo(Sottoruolo s){
    if(ruolo == Ruolo.ATTACCANTE && (s !=Sottoruolo.ATT && s != Sottoruolo.AS && s != Sottoruolo.AD && s!= Sottoruolo.AT))
    throw new RuntimeException();
    else sottoruolo = s;
}

public String toString(){
    if(sottoruolo == null)
    return nome+": "+ruolo.name();
    else     return nome+": "+ruolo.name()+"-"+sottoruolo.name();
 
}
}