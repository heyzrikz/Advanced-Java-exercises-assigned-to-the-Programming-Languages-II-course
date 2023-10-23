

public class Main {
    public static void main(String[] args){
        Question q = new Question("Dove␣si␣trova␣Albuquerque?");
Answer a1 = new Answer(q, "Canada");
Answer a2 = new Answer(q, "New␣Mexico");
a1.voteUp();
System.out.println(q.getBestAnswer());
a2.voteUp();
a2.voteUp();
System.out.println(q.getBestAnswer());


    }

   
    
}
