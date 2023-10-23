import java.util.ArrayList;
import java.util.List;

public class Question{
    Question(){
        domanda = "";
        max_vote = 0;
        risposte = new ArrayList<Answer>();
    }
    private String domanda;
    protected List<Answer> risposte;
    public int max_vote;
    Question(String d){
        domanda = d;
        max_vote = 0;
        risposte = new ArrayList<Answer>();
    }

    public String getBestAnswer(){
        String res="";
        for(Answer a: risposte){
            if(a.voti == max_vote) res = res + a.risposta;
        }
        return res;
    }


}