public class Answer extends Question{
    protected String risposta;
    private Question question;
    protected int voti; 
    Answer(Question q , String r){
        question = q;
        risposta = r;
        voti = 0;
        question.risposte.add(this);
    }

    public void voteUp(){
        voti++;
        if(voti > question.max_vote) question.max_vote = voti; 
    }
}